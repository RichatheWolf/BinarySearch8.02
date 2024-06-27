import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class MusicTesterV3{
	public static void main(String[] args) {
		// Declare an array of Music
		final int SIZE = 12;
		Music[] song = new Music[SIZE];
		// initialize music array
		song[0] = new Music("Video Games", 2012, "Lana Del Rey");
		song[1] = new Music("Tank!", 1998, "Seatbelts");
		song[2] = new Music("The 30th", 2022, "Billie Eilish");
		song[3] = new Music("Cruel Summer", 2019, "Taylor Swift");
		song[4] = new Music("4:00 AM", 1978, "Taeko Onuki");
		song[5] = new Music("Colors", 2006, "FLOW");
		song[6] = new Music("Winding Through Avidya", 2023, "HOYO-MiX");
		song[7] = new Music("Kaikai Kaitan", 2020, "EVE");
		song[8] = new Music("Matoryoshka", 2010, "Kenshi Yonezu");
		song[9] = new Music("Diet Mountain Dew", 2012, "Lana Del Rey");
		song[10] = new Music("Colors", 2015, "Halsey");
		song[11] = new Music("KICK BACK", 2022, "Kenshi Yonezu");
		
		// Call function
		printMusic(song);
		sortByTitle(song);
		System.out.println();
		System.out.println("After Sorting by Title:");
		printMusic(song);
		sortByYear(song);
		System.out.println();
		System.out.println("After Sorting by Year:");
		printMusic(song);
		sortByArtist(song);
		System.out.println();
		System.out.println("After Sorting by Artist:");
		printMusic(song);
		System.out.println();
		System.out.println("_____ Searching for artist \"EVE\" in the Array ____");
		searchArtist(song, "EVE");
		System.out.println();
		System.out.println("_____ Searching for title \"39 Music!\" in the Array ____");
		searchTitle(song, "39 Music!");
		System.out.println();
		System.out.println("_____ Searching for year \"2022\" in the Array ____");
		searchYear(song, 2022);
	}
	
	private static void sortByArtist(Music[] arr) {
		int size = arr.length;
		Music temp;
		for (int m = 1; m < size; m++) {
			String val = arr[m].getArtist();
			temp = arr[m];
			int n = m - 1;
			while ((n > -1) && (arr[n].getArtist().compareTo(val) > 0)) {
				arr[n + 1] = arr[n];
				n--;
			}
			arr[n + 1] = temp;
		}
		
	}
	
	private static void sortByYear(Music[] arr) {
		int size = arr.length;
		Music temp;
		for (int m = 1; m < size; m++) {
			int val = arr[m].getYear();
			temp = arr[m];
			int n = m - 1;
			while ((n > -1) && (arr[n].getYear() > val)) {
				arr[n + 1] = arr[n];
				n--;
			}
			arr[n + 1] = temp;
		}
		
	}
	
	private static void sortByTitle(Music[] arr) {
		int size = arr.length;
		Music temp;
		for (int m = 1; m < size; m++) {
			String val = arr[m].getTitle();
			temp = arr[m];
			int n = m - 1;
			while ((n > -1) && (arr[n].getTitle().compareTo(val) > 0)) {
				arr[n + 1] = arr[n];
				n--;
			}
			arr[n + 1] = temp;
		}
		
	}
	
	private static void printMusic(Music[] music) {
		String str = String.format("%-25s %4s %-20s ", "Title", "Year",
				"Artist");
		System.out.println(str);
		System.out.println("===========================================");
		for (Music m : music) {
			System.out.println(m);
		}
	}
	
	// Searches array for particular song
	private static void searchTitle(Music[] music, String title) {
		int low = 0;
		int pos=0;
		int high = music.length - 1;
		int index=0;
		boolean found = false;
		while (!found && low <= high) {
			int middle = (low + high) / 2;
			
			if (music[middle].getTitle().compareTo(title) == 0){
				
				pos = middle;
				index = middle;
				found = true;
			} else if (music[middle].getTitle().compareTo(title) < 0) {
				high = middle - 1;
			} else if (music[middle].getTitle().compareTo(title) > 0) {
				low = middle + 1;
			}
			
		}
		if(found) {
			System.out.println(music[pos]);
		}
		else {
			System.out.println("title \""+title+"\" not found in this playlist.");
		}
		
	}
	
	private static void searchArtist(Music[] music, String artist) {
		int flag = 0;
		for (Music m : music) {
			if (m.getArtist().equalsIgnoreCase(artist)) {
				flag = 1;
				System.out.println(m);
			}
		}
		if (flag == 0)
			System.out.println(artist + " not found.");
	}
	
	private static void searchYear(Music[] music, int year) {
		int flag = 0;
		for (Music m : music) {
			if (m.getYear() == year) {
				flag = 1;
				System.out.println(m);
			}
		}
		if (flag == 0) {
			System.out.println(year + " is not found.");
		}
	}
}