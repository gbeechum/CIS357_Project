
public class Main {
	public static void main(String[] args) {
		Catalogue Catalogue = new Catalogue();
		Catalogue.addBook(810, "Shrek", "Gayyyy");
		Catalogue.addBook(180, "Zanzabar", "Ayyyyyyyyyyyyyy");
		
		System.out.print(Catalogue.toString());
		
		Catalogue.sortByISBN();
		
		System.out.print(Catalogue.toString());
		
		Catalogue.sortByTitle();
		
		System.out.print(Catalogue.toString());
	}
}
