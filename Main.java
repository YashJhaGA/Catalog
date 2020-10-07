package Mcat;

import java.nio.file.Paths;
import java.util.*;

public class Main {
	public static void main(String[] args) {
		List<SongInfo> cataloog = new ArrayList<>();
		cataloog.add(new SongInfo("Placeholder","Placeholder","Placeholder",0,0,"Placeholder","Placeholder",0,0));
		int count = 0;
		try (Scanner scanner = new Scanner(Paths.get("MonstercatFull.txt"))) {
			while (scanner.hasNextLine()) {
				count++;
				String songName = scanner.nextLine();
				if(count == 1 && songName.contains("¿")) {
					String[] tempo = songName.split("¿");
					songName = tempo[1];
				}
				String artist = scanner.nextLine();
				String album = scanner.nextLine();
				String info = scanner.nextLine();
		/*		String[] data = info.split(",");
				String[] time = data[0].split(":");
				int songLength = (Integer.valueOf(time[0]) * 60) + Integer.valueOf(time[1]);
				int bpm = Integer.valueOf(data[1]);
				String genre = data[2];
				String month = data[3];
				int d = Integer.valueOf(data[4].trim());
				int y = Integer.valueOf(data[5].trim()); */
				
				String[] data = info.split("\\s+");
				String[] time = data[0].split(":");
				int songLength = (Integer.valueOf(time[0]) * 60) + Integer.valueOf(time[1]);
				int bpm = Integer.valueOf(data[1]);
				if(data.length == 6) {
				String genre = data[2];
				String month = data[3];
				String[] dayCom = data[4].split(",");
				int day = Integer.valueOf(dayCom[0].trim()); 
				int year = Integer.valueOf(data[5].trim());
				cataloog.add(new SongInfo(songName, artist, album, songLength, bpm, genre, month, day, year));
			} else if(data.length == 7){
				String genre = data[2]+" "+data[3];
				String month = data[4];
				String[] dayCom = data[5].split(",");
				int day = Integer.valueOf(dayCom[0].trim()); 
				int year = Integer.valueOf(data[6].trim());
				cataloog.add(new SongInfo(songName, artist, album, songLength, bpm, genre, month, day, year));
			} else if(data.length == 8) {
				String genre = data[2]+" "+data[3]+" "+data[4];
				String month = data[5];
				String[] dayCom = data[6].split(",");
				int day = Integer.valueOf(dayCom[0].trim()); 
				int year = Integer.valueOf(data[7].trim());
				cataloog.add(new SongInfo(songName, artist, album, songLength, bpm, genre, month, day, year));
			} else if(data.length == 10) {
				String genre = data[2]+" "+data[3]+" "+data[4]+" "+data[5]+" "+data[6];
				String month = data[7];
				String[] dayCom = data[8].split(",");
				int day = Integer.valueOf(dayCom[0].trim());
				int year = Integer.valueOf(data[9].trim());
				cataloog.add(new SongInfo(songName, artist, album, songLength, bpm, genre, month, day, year));
			}
				
//				cataloog.add(new SongInfo(songName, artist, songLength, bpm, genre, month, d, y));
				
				if (!scanner.hasNextLine())
					break;
				if (scanner.nextLine().equals("")) {
					continue;
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(SongInfo x: cataloog) {
			x.setMonth();
		} 
		Scanner scan = new Scanner(System.in);
		Catalog cat = new Catalog(cataloog,scan);
		UserInterface ui = new UserInterface(scan, cat);
		ui.start();
	}
}
