package Mcat;

public class SongInfo {
	private String songName;
	private String artist;
	private String album;
	private int songSeconds;
	private int bpm;
	private String genre;
	private String month;
	private int day;
	private int year;
	
	public SongInfo(String song, String artist, String album,int songlength, int bpm, String g, String m, int d, int y) {
		this.songName = song;
		this.artist = artist;
		this.album = album;
		this.songSeconds = songlength;
		this.bpm = bpm;
		this.genre = g;
		this.month = m;
		this.day = d;
		this.year = y;
	}
	public void setMonth() {
		if(this.month.equals("Jan")) {
			this.month = "January";
		} else if(this.month.equals("Feb")) {
			this.month = "February";
		} else if(this.month.equals("Mar")) {
			this.month = "March";
		} else if(this.month.equals("Apr")) {
			this.month = "April";
		} else if(this.month.equals("Jun")) {
			this.month = "June";
		} else if(this.month.equals("Jul")) {
			this.month = "July";
		} else if(this.month.equals("Aug")) {
			this.month = "August";
		} else if(this.month.equals("Sep")) {
			this.month = "September";
		} else if(this.month.equals("Oct")) {
			this.month = "October";
		} else if(this.month.equals("Nov")) {
			this.month = "November";
		} else if(this.month.equals("Dec")) {
			this.month = "December";
		} else {
			return;
		}
	}
	
	public String getSongName() {
		return songName;
	}

	public String getArtist() {
		return artist;
	}
	public String album() {
		return album;
	}

	public int getSongSeconds() {
		return songSeconds;
	}

	public int getBpm() {
		return bpm;
	}

	public String getGenre() {
		return genre;
	}

	public String getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artist == null) ? 0 : artist.hashCode());
		result = prime * result + bpm;
		result = prime * result + day;
		result = prime * result + ((genre == null) ? 0 : genre.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((songName == null) ? 0 : songName.hashCode());
		result = prime * result + songSeconds;
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SongInfo))
			return false;
		SongInfo other = (SongInfo) obj;
		if (artist == null) {
			if (other.artist != null)
				return false;
		} else if (!artist.equals(other.artist))
			return false;
		if (bpm != other.bpm)
			return false;
		if (day != other.day)
			return false;
		if (genre == null) {
			if (other.genre != null)
				return false;
		} else if (!genre.equals(other.genre))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (songName == null) {
			if (other.songName != null)
				return false;
		} else if (!songName.equals(other.songName))
			return false;
		if (songSeconds != other.songSeconds)
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.songName+" by "+this.artist+"("+this.year+")";
	}
	
	public String advanced() {
		if(day == 1 || day == 21) {
			return this.songName+" by "+this.artist+"\nLength: "+(this.songSeconds/60)+" minutes "+(this.songSeconds%60)+" seconds\nBPM: "+this.bpm+"\nGenre: "+this.genre+"\nRelease Date: "+this.month+" "+this.day+"st,"+this.year+"\n";
		}else if(day == 2 || day == 22) {
			return this.songName+" by "+this.artist+"\nLength: "+(this.songSeconds/60)+" minutes "+(this.songSeconds%60)+" seconds\nBPM: "+this.bpm+"\nGenre: "+this.genre+"\nRelease Date: "+this.month+" "+this.day+"nd,"+this.year+"\n";
		}else if(day == 3 || day == 23) {
			return this.songName+" by "+this.artist+"\nLength: "+(this.songSeconds/60)+" minutes "+(this.songSeconds%60)+" seconds\nBPM: "+this.bpm+"\nGenre: "+this.genre+"\nRelease Date: "+this.month+" "+this.day+"rd,"+this.year+"\n";
		} else {
		return this.songName+" by "+this.artist+"\nLength: "+(this.songSeconds/60)+" minutes "+(this.songSeconds%60)+" seconds\nBPM: "+this.bpm+"\nGenre: "+this.genre+"\nRelease Date: "+this.month+" "+this.day+"th,"+this.year+"\n";
	}
	}
	
	public String monthDate() {
		if(day == 1 || day == 21) {
			return this.songName+" by "+this.artist+" ("+this.month+" "+this.day+"st)";
		} else if(day == 2 || day == 22) {
			return this.songName+" by "+this.artist+" ("+this.month+" "+this.day+"nd)";
		} else if(day == 3 || day == 23) {
			return this.songName+" by "+this.artist+" ("+this.month+" "+this.day+"rd)";
		}
		return this.songName+" by "+this.artist+" ("+this.month+" "+this.day+"th)";
	}
	
}
