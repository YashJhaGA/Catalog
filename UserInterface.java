package Mcat;

import java.util.*;

public class UserInterface {
	Scanner scan;
	Catalog cat;
	PlaylistManager manag;

	public UserInterface(Scanner scan, Catalog cat) {
		this.scan = scan;
		this.cat = cat;
		manag = new PlaylistManager(cat, scan);
	}

	public void start() {
		System.out.println("Program Functions");
		System.out.println("-----------------");
		System.out.println("1.Look at Catalog");
		System.out.println("2.Create a playlist");
		System.out.println("3.Manage a playlist");
		System.out.println("4.Print a playlist\n");
		while (true) {

			System.out.print("Input your choice(type exit to end/help for help): ");
			String input = scan.nextLine();

			if (input.equals("exit")) {
				break;
			}
			if (input.equals("help")) {
				System.out.println("1.Look at Catalog");
				System.out.println("2.Create a playlist");
				System.out.println("3.Manage a playlist");
				System.out.println("4.Print a playlist\n");
				continue;
			}
			checkCommand(input);
		}
	}

	public void checkCommand(String input) {
		if (input.equals("1")) {
			catlog();
		} else if (input.equals("2")) {
			playlistCreator();
		} else if (input.equals("3")) {
			playlistManager();
		} else if (input.equals("4")) {
			playlistViewer();
		} else {
			System.out.println("Invalid Input!");
		}

	}

	public void catlog() {
		System.out.print(
				"Would you like to print the full catalog(full),get a mystery track(mystery), or do an advanced search(search)? ");
		String decision = scan.nextLine();
		if (decision.equalsIgnoreCase("full")) {
			System.out.print("Would you like it normal(1) or advanced(2)? ");
			String choice = scan.nextLine();
			if (choice.equals("normal") || choice.equals("1")) {
				System.out.println("Song | Artist |     Length(seconds)");
				cat.printCatalog(false);
			} else if (choice.equals("advanced") || choice.equals("2")) {
				cat.printCatalog(true);
			} else {
				System.out.println("Invalid Input. Returning to main.");
			}
		} else if (decision.equalsIgnoreCase("mystery")) {
			mystery();
		} else if (decision.equalsIgnoreCase("search")) {
			advancedSearch();
		} else {
			System.out.println("Invalid input. Returning to main.");
		}
	}

	public void mystery() {
		while (true) {
			cat.mysteryTrack();
			System.out.print("Another? (Y/N): ");
			String pick = scan.nextLine();
			if (pick.matches("(Y|YE|YES|y|ye|yes)")) {
				continue;
			} else {
				break;
			}
		}
	}

	public void advancedSearch() {
		System.out.print("Would you like to search for a (song) or filter by (artist),(genre),or (date)? ");
		String decision = scan.nextLine();
		if (decision.equalsIgnoreCase("song")) {
			System.out.print("Name of song: ");
			String song = scan.nextLine();
			System.out.println();
			cat.songInfo(song);
		} else if (decision.equalsIgnoreCase("artist")) {
			System.out.print("Name of artist: ");
			String artist = scan.nextLine();
			System.out.println();
			cat.printArtist(artist);
		} else if (decision.equalsIgnoreCase("genre")) {
			System.out.print("Genre: ");
			String genre = scan.nextLine();
			System.out.println();
			cat.printCatalogByGenre(genre);
		} else if (decision.equalsIgnoreCase("date")) {
			System.out.print("Would you like to search an (exact) date or have a broader (filter)? ");
			String pick = scan.nextLine();
			if (pick.equalsIgnoreCase("exact")) {
				System.out.print("Input month: ");
				String moth = scan.nextLine();
				System.out.print("Input day: ");
				int da = Integer.valueOf(scan.nextLine());
				System.out.print("Input year: ");
				int yea = Integer.valueOf(scan.nextLine());
				System.out.println();
				cat.exactDate(moth, da, yea);
			} else if (pick.equalsIgnoreCase("filter")) {
				filter();
			} else {
				System.out.println("Invalid Input. Returning to main.");
			}
		}
	}

	public void filter() {
		System.out.print("How would you like to filter(1.Month+Year, 2.Month, 3.Year)? ");
		int picker = Integer.valueOf(scan.nextLine());
		if (picker == 1) {
			System.out.print("Input a month: ");
			String month = scan.nextLine();
			System.out.print("Input a year: ");
			int year = Integer.valueOf(scan.nextLine());
			cat.monthYear(month, year);
		} else if (picker == 2) {
			System.out.print("Input a month: ");
			String month = scan.nextLine();
			cat.monthSearch(month);
		} else if (picker == 3) {
			System.out.print("Input a year: ");
			int year = Integer.valueOf(scan.nextLine());
			cat.yearSearch(year);
		} else {
			System.out.println("Invalid Input. Returning to main");
		}
	}

	public void playlistCreator() {
		List<SongInfo> newPlaylist = new ArrayList<>();

		System.out.print("What would you like to name the playlist? ");
		String playName = scan.nextLine();
		if (!manag.checkKey(playName)) {
			while (true) {
				System.out.print("Which song would you like to add? ");
				String song = scan.nextLine();
				if (cat.catalogContains(song)) {
					newPlaylist.add(cat.get(cat.getIndex(song)));
					manag.add(playName, newPlaylist);
					break;
				} else {
					System.out.println("\nSong not found!");
				}

			}
			System.out.print("Continue adding? (Y/N): ");
			String choiceD = scan.nextLine();
			if (choiceD.matches("(Y|YE|YES|y|ye|yes)")) {
				this.managerAdd(playName);
			} else {

			}
		} else {
			System.out.println("Playlist is already in use!");
		}
	}

	public void playlistManager() {
		if(manag.checkIfPlaylistExists()) {
			System.out.print("\nNo Current Playlists Active! \nCreate a playlist? (Y/N) : ");
			String createP = scan.nextLine();
			if(createP.matches("(Y|YE|YES|y|ye|yes)")) {
				this.playlistCreator();
			} else {
				
			}
			
		} else {
		System.out.println("All Playlists\n_____________");
		manag.printKeys();

		System.out.print("Which playlist would you like to manage? ");
		int listPick = Integer.parseInt(scan.nextLine());
		String editor = manag.getKey(listPick);
		if (manag.checkKey(editor)) {
			System.out.print("What would you like to do? Add Song(1), Remove Song(2), or Delete Playlist(3)? ");
			int choice = Integer.valueOf(scan.nextLine());
			
			if (choice == 1) {
				this.managerAdd(editor);
			} else if (choice == 2) {
				this.managerRemove(editor);
			} else if (choice == 3) {
				this.managerDelete(editor);
			} else {
				System.out.println("Invalid Input!");
			}
		} else {
			System.out.println("Playlist doesn't exist!");
		}
		}
	}

	public void managerAdd(String editor) {
		while (true) {
			System.out.print("What song would you like to add? ");
			String songchoice = scan.nextLine();
			manag.addSong(editor, songchoice);
			System.out.print("Continue? (Y/N): ");
			String decision = scan.nextLine();
			if (decision.matches("(Y|YE|YES|y|ye|yes)")) {
				continue;
			} else {
				break;
			}
		}
	}

	public void managerRemove(String editor) {
		System.out.print("Which song would you like to remove? ");
		String remover = scan.nextLine();
		System.out.print("Written by which artist? ");
		String artistRemo = scan.nextLine();
		manag.removeSong(editor, remover, artistRemo);
	}

	public void managerDelete(String editor) {
		manag.deletePlaylist(editor);
	}

	public void playlistViewer() {
		System.out.println("\nAll Playlists\n-------------");
		manag.printKeys();

		System.out.print("\nPick which playlist to print: ");
		int choice = Integer.parseInt(scan.nextLine());
		String playName = manag.getKey(choice);
		System.out.println();
		if (manag.checkKey(playName)) {
			manag.printVal(playName);
			System.out.println();
		} else {
			System.out.println("Playlist does not exist");
		}
	}
}
