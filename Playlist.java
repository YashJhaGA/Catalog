package Mcat;
import java.util.*;
public class Playlist {
	List<SongInfo> playlist;
	
	public Playlist() {
		playlist = new ArrayList<>();
	}
	
	public void add(SongInfo si) {
		playlist.add(si);
	}
	
	public void print() {
		Iterator<SongInfo> iter = playlist.iterator();	
		
		while(iter.hasNext()) {
			System.out.println(iter.next()+"\n");
		}
	}
	
	public void print(String genre) {
			
		for(SongInfo sinfo: playlist) {
			if(sinfo.getGenre().equals(genre)) {
				System.out.println(sinfo+"\n");
			}
		} 
		
		}
		
	
}

