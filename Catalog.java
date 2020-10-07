package Mcat;

import java.util.*;

public class Catalog {
	private List<SongInfo> catalog;
	private Scanner scanner;

	public Catalog(List<SongInfo> cataloog, Scanner scanner) {
		this.catalog = cataloog;
		this.scanner = scanner;
	}

	public boolean catalogContains(String song) {
		
		for (SongInfo x : catalog) {
			if (x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	public SongInfo getSong(int index) {
		return catalog.get(index);
	}

	public List<SongInfo> getList() {
		return catalog;
	}

	public void printCatalog(boolean x) {
		Iterator<SongInfo> iter = this.catalog.iterator();
		System.out.println();
		int count = 0;
		while (iter.hasNext()) {
			count++;
			if (x == false) {
				System.out.println(count+"."+iter.next());
			} else {
				System.out.println(count+"."+iter.next().advanced()+"\n");
			}
		}
	}

	public void printCatalogByGenre(String genre) {
		genre.toLowerCase();
		String x = genre.substring(0,1).toUpperCase()+genre.substring(1);
		System.out.println(x+" songs\n----------");
		for (SongInfo sinfo : catalog) {
			if (sinfo.getGenre().equalsIgnoreCase(genre)) {
				System.out.println(sinfo);
			}
		}
		System.out.println();
	}

	public int getIndex(String song) {
		int instance = this.getInstance(song);
		int index = -1;
		int count = -1;
		int[] indexHold = new int[instance];
	
		for(SongInfo x: catalog) {
			index++;
			if(x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				count++;
				indexHold[count] = index;
			}
		}
		if(indexHold.length == 1) {
			return indexHold[0];
		} else {
				System.out.println();
			for(int i = 0; i<indexHold.length; i++) {
				System.out.println((i+1)+": "+this.get(indexHold[i]));
			}
			System.out.print("\nSelect which to add: ");
			int pick = Integer.parseInt(scanner.nextLine());
			return indexHold[pick-1];
		}
	}
	
	public int pickSong(int index, int index2) {
		System.out.println("1."+this.get(index));
		System.out.println("2."+this.get(index2));
		Scanner scanster = new Scanner(System.in);
		System.out.print("> ");
		int picko = Integer.parseInt(scanster.nextLine());
		scanster.close();
		if(picko == 1) return index;
		return index2;
		
	}

	public SongInfo get(int index) {
		return catalog.get(index);
	}

	public void printArtist(String artist) {
		int check = 0;
		for(SongInfo sinfo : catalog) {
			if(sinfo.getArtist().contains(artist)) {
				check++;
				System.out.println(sinfo.getSongName()+"("+sinfo.getYear()+")");
			}
		}
		System.out.println();
		if(check == 0) {
			System.out.println("Artist "+artist+" has not released on Monstercat!");
		}
	}
	
	public void songInfo(String song) {
		for(SongInfo x: catalog) {
			if(x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				System.out.println(x.advanced());
			}
		}
	}

	public void exactDate(String moth, int da, int yea) {
		int count = 0;
		for(SongInfo x: catalog) {
			if(x.getMonth().equalsIgnoreCase(moth) && x.getDay() == da && x.getYear() == yea) {
				count++;
				System.out.println(x.advanced());
			}
		}
		if(count == 0) System.out.println("No song was uploaded on that day!\n");
	}

	public void monthYear(String month, int year) {
		System.out.println();
		for(SongInfo x: catalog) {
			if(x.getMonth().equalsIgnoreCase(month) && x.getYear() == year) {
				System.out.println(x.monthDate());
			}
		}
		System.out.println();
	}

	public void monthSearch(String month) {
		System.out.println();
		for(SongInfo x: catalog) {
			if(x.getMonth().equalsIgnoreCase(month)) {
				System.out.println(x);
			}
		}
		System.out.println();
	}

	public void yearSearch(int year) {
		System.out.println();
		for(SongInfo x: catalog) {
			if(x.getYear() == year) {
				System.out.println(x);
			}
		}
		System.out.println();
	}

	public int getInstance(String song) {
		int count = 0;
		for(SongInfo x: catalog) {
			if(x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				count++;
			}
		}
		return count;
	}
	
	public Integer[] getIndexes(String song,int instances) {
		Integer [] array = new Integer[instances];
		int i = 0;
		int count = -1;
		for(SongInfo x: catalog) {
			count++;
			if(x.getSongName().toLowerCase().contains(song.toLowerCase())) {
				array[i] = count;
				i++;
			}
		}
		return array;
	}

	public void mysteryTrack() {
		Random rando = new Random();
		int index = rando.nextInt(catalog.size());
		System.out.println("\nMystery Track\n-------------\n"+catalog.get(index).advanced());
		
		
	}
 	
}
