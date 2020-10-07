package Mcat;

import java.util.*;

public class PlaylistManager {
	HashMap<String, List<SongInfo>> playHolder;
	Catalog c;
	Scanner scanner;
	public PlaylistManager(Catalog c, Scanner scanner) {
		playHolder = new HashMap<>();
		this.c = c;
		this.scanner = scanner;
	}
	public void addSongInfo(String playName, SongInfo song) {
		//
	}
	public void add(String playlistName, List<SongInfo> playlist) {
		if (playHolder.containsKey(playlistName)) {
			System.out.println("Error! Playlist is already in use.");
			return;
		}
		playHolder.put(playlistName, playlist);
		System.out.println("Success! Playlist created.");
	}
	
	public void addSong(String key, String song) {
		int instance = c.getInstance(song);
		// If Song Input doesn't exist
		if(instance == 0) {
			System.out.println("Song doesn't exist!");
			return;
		}
		
		ArrayList<SongInfo> playlistCheck = new ArrayList<>();
		int count = 0;
		// If Song only exists once and is already in the play list
		for(SongInfo x: playHolder.get(key)) { 
			if(x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				count++;
				playlistCheck.add(x);
				}
			}
		if(count == instance) {
			System.out.println("Song(s) are already in the playlist!");
			return;
		}
		if(count == 0 && instance == 1) {
			playHolder.get(key).add(c.get(c.getIndex(song)));
			return;
		}
		Integer[] indexOfSong = c.getIndexes(song, instance);

		int counto  = 0;
		for(int i = 0; i<playlistCheck.size();i++) {
			for(int j =0; j<indexOfSong.length;j++) {
				if(playlistCheck.get(i).hashCode() == c.getSong(indexOfSong[j]).hashCode()) {
					indexOfSong[j] = 0;
					counto++;
				}
			}
		}

		
		int iterato = 0;
		int [] pureList = new int[instance-counto];
		for(int i = 0; i<indexOfSong.length; i++) {
			if(indexOfSong[i] != 0) {
				pureList[iterato] = indexOfSong[i];
				iterato++;
			}
		}
		
		if(pureList.length == 1) {
			playHolder.get(key).add(c.getSong(pureList[0]));
			return;
		}
		String songNameUpdate = song.substring(0,1).toUpperCase()+song.substring(1).toLowerCase();
		System.out.println("\nSongs containing '"+songNameUpdate+"':\n");
		for(int i = 0; i<pureList.length;i++) {
			System.out.println((i+1)+": "+c.getSong(pureList[i]));
		}
		System.out.println();
		
		System.out.print("Pick a number to add: ");
		int input = Integer.parseInt(scanner.nextLine());
		if(input > -1 || input < pureList.length) {
			playHolder.get(key).add(c.getSong(pureList[input-1]));
	//		System.out.println(playHolder.get(key));
			return;
		} else {
			System.out.println("Invalid Input!");
			return;
		}
		
		

	}
	
	public void removeSong(String key, String song,String artist) {
		int index = -1;
		ArrayList<Integer> listOfSong = new ArrayList<Integer>();
		for (SongInfo x : playHolder.get(key)) {
			index++;
			if (x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				listOfSong.add(index);
			}
		}
		if (listOfSong.isEmpty()) {
			System.out.println("Song is not in the playlist!");
			return;
		} else if(listOfSong.size() == 1) {
			playHolder.get(key).remove(playHolder.get(key).get(0));
		} else {
			int count = 0;
			System.out.println("Multiple songs containing '"+song+"'\n");
			for(Integer x: listOfSong) {
				count++;
				System.out.println(count+": "+playHolder.get(key).get(x));
			}	
				System.out.print("\nPick a number to remove: ");
				int removePick = Integer.parseInt(scanner.nextLine());
				if(removePick > -1 || removePick < listOfSong.size()) {
					playHolder.get(key).remove(playHolder.get(key).get(listOfSong.get(removePick-1)));
				} else {
					System.out.println("Invalid Input");
					return;
				}
			
		}
	}
	
	public void deletePlaylist(String key) {
		if(checkKey(key)) {
			playHolder.remove(key);
		} 
	}

	public boolean checkKey(String key) {
		for (String x : playHolder.keySet()) {
			if (x.equals(key)) {
				return true;
			}
		}
		return false;
	}
	
	public List<SongInfo> keyVal(String key) {
		return playHolder.getOrDefault(key, new ArrayList<>());
	}
	
	public boolean checkIfPlaylistExists() {
		if(playHolder.isEmpty()) return true;
		return false;
	}

	public void printVal(String key) {
		int order = 0;;
		if (playHolder.containsKey(key)) {
			// System.out.println(playHolder.get(key));
			Iterator<SongInfo> iter = playHolder.get(key).iterator();
			while(iter.hasNext()) {
				order++;
				System.out.println(order+": "+iter.next());
			}
		} else {
			System.out.println("Key doesn't exist");
		}
	}

	public void printKeys() {
		int count = 0;
		for (String x : playHolder.keySet()) {
			count++;
			System.out.println(count+":"+x+" ("+playHolder.get(x).size()+" songs)");
		}
	}
	
	public String getKey(int choice) {
		if(choice < 0 || choice > playHolder.size()) return "Invalid Input";
		int index = -1;

		for(String x: playHolder.keySet()) {
			index++;
			if(index+1 == choice) {
				return x;
			}
		}
		return "Invalid Input";
	}
}
