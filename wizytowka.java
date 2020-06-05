package wizytowka;

import java.io.FileWriter;			//Biblioteka odpowiadaj�ca za obs�uge zapisu do pliku
import java.io.BufferedReader;			//Biblioteka odpowiadaj�ca za obs�uge zapisu do pliku
import java.io.File;			//Biblioteka odpowiadaj�ca za obs�uge dost�pu do pliku
import java.io.FileReader;			//Biblioteka odpowiadaj�ca za obs�uge odczytu z pliku
import java.io.IOException;			//Biblioteka odpowiadaj�ca za obs�ug� wyj�tk�w (try...catch)
import java.time.LocalDateTime;			//Biblioteka odpowiadaj�ca za odczyt aktualnej daty i czasu
import java.util.ArrayList;			//Biblioteka odpowiadaj�ca za operacje na listach
import java.util.Random;			//Biblioteka obs�uguj�ca liczby pseudo losowe
import java.util.Scanner;			//Biblioteka odpowiadaj�ca za pobieranie danych z klawiatury
import java.util.Vector;			//Biblioteka odpowiadaj�ca za obs�ug� vector�w

//Patryk Andrzejewski
//U-15565
//Wizyt�wka

/* Test szyfrowania
String test = "Patryk Andrzejewski";
System.out.println(szyfrowanie(test));
System.out.println(odszyfrowanie(test));
*/

public class wizytowka {			//G��wna klasa
	int id;			//Utworzenie zmiennej id
	String imie;			//Utworzenie zmiennej imie
	String nazwisko;			//Utworzenie zmiennej nazwisko
	String n_f;			//Utworzenie zmiennej n_f
	String a_f;			//Utworzenie zmiennej a_f
	String regon;			//Utworzenie zmiennej regon
	String telefon;			//Utworzenie zmiennej telefon
	String adresmail;			//Utworzenie zmiennej adresmail
	//Kreator obiektu
	public wizytowka(int id,String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
    	this.id = id;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.imie = imie;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.nazwisko = nazwisko;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.n_f = n_f;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.a_f = a_f;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.regon = regon;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.telefon = telefon;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	this.adresmail = adresmail;			//nadanie zmiennej warto�ci otrzymanej przy wywo�aniu kreatora
    	zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//Wywo�anie funkcji zapisu do pliku
    }
	//Funkcja z menu
	public static void menu() {
		System.out.println("Menu programu wizytowka");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
		System.out.println("1. Zapisz dane");			//Wy�wietlanie tre�ci menu
		System.out.println("2. Odczytaj dane");			//Wy�wietlanie tre�ci menu
		System.out.println("3. Utw�rz losowo 100 wizytowek");			//Wy�wietlanie tre�ci menu
		System.out.println("4. Utw�rz losowo 1 wizytowke");			//Wy�wietlanie tre�ci menu
		System.out.println("5. Zarzadzanie lista");			//Wy�wietlanie tre�ci menu
		System.out.println("6. Ilosc 3 imion");			//Wy�wietlanie tre�ci menu
		System.out.println("7. Vektor");			//Wy�wietlanie tre�ci menu
		System.out.println("8. Babelkowe");			//Wy�wietlanie tre�ci menu
		System.out.println("9. Sprawdzenie ile jest wybranych imion");
		System.out.println("10. Zamknij program");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
	}
	public static void menulista() {
		System.out.println("Podmenu lista");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
		System.out.println("1. Utw�rz list� 100 losowych imion");			//Wy�wietlanie tre�ci menu
		System.out.println("2. Wy�wietl list� imion");			//Wy�wietlanie tre�ci menu
		System.out.println("3. Usun element listy");			//Wy�wietlanie tre�ci menu
		System.out.println("4. Zamien element listy");			//Wy�wietlanie tre�ci menu
		System.out.println("5. Wyczysc liste");			//Wy�wietlanie tre�ci menu
		System.out.println("6. Powrot");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
	}
	public static void menubabelkowa() {
		System.out.println("Podmenu babelkowego");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
		System.out.println("1. Utw�rz list� 100 losowych nazwisk");			//Wy�wietlanie tre�ci menu
		System.out.println("2. Wy�wietl list� nazwisk");			//Wy�wietlanie tre�ci menu
		System.out.println("3. Dokonaj sortowania");			//Wy�wietlanie tre�ci menu
		System.out.println("4. Dokonaj sortowania krok po kroku");			//Wy�wietlanie tre�ci menu
		System.out.println("5. Powrot");			//Wy�wietlanie tre�ci menu
		System.out.println("-----------------------");			//Wy�wietlanie tre�ci menu
	}
	//Funkcja odpowiadaj�ca za dodawanie danych do pliku zapis.txt
	public static void zapis_wizytowka(String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
		try {
			FileWriter Zapis = new FileWriter("zapis.txt", true);			//Utworzenie zmiennej zapis kt�ra daje dost�p do pliku "zapis.txt" znajduj�cego si� w folderze z klas� oraz nadanie jej atrybutu "true" kt�ry odpowiada za dodawanie danych na ko�cu pliku zamiast go nadpisywa�
			imie = (imie + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			imie = szyfrowanie(imie);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(imie);			//Zapis danych do pliku
			nazwisko = (nazwisko + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			nazwisko = szyfrowanie(nazwisko);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(nazwisko);			//Zapis danych do pliku
			n_f = (n_f + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			n_f = szyfrowanie(n_f);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(n_f);			//Zapis danych do pliku
			a_f = (a_f + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			a_f = szyfrowanie(a_f);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(a_f);			//Zapis danych do pliku
			regon = (regon + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			regon = szyfrowanie(regon);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(regon);			//Zapis danych do pliku
			telefon = (telefon + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			telefon = szyfrowanie(telefon);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(telefon);			//Zapis danych do pliku
			adresmail = (adresmail + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			adresmail = szyfrowanie(adresmail);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(adresmail);			//Zapis danych do pliku
			String data = ("Data utworzenia: " + LocalDateTime.now() + "\r\n");			//Dodanie do zmiennej ci�gu znaku odpowiadaj�cego za przej�cie do nowej lini
			data = szyfrowanie(data);			//Wywo�anie funkcji szyfrowania danych i zapis zwr�conych danych do zmiennej
			Zapis.write(data);			//Zapis aktualnej daty z komputera do pliku
			Zapis.close();			//Zamkni�cie dost�pu do pliku
		}catch (IOException a) {
			System.out.println("*Wyst�pi� b��d podczas pr�by zapisu do pliku*");			//Informacja o b�edzie
			a.printStackTrace();
		}
	}
	//Funkcja odpowiadaj�ca za odczyt danych z pliku zapis.txt
	public static void odczyt_wizytowek() {
		try {
			FileReader Odczyt = new FileReader("zapis.txt");			//Utworzenie zmiennej odczyt kt�ra daje dost�p do pliku "zapis.txt" znajduj�cego si� w folderze z klas�.
			BufferedReader bodczyt = new BufferedReader(Odczyt);
			String linia;		//Deklaracja zmiennej	
			while ((linia = bodczyt.readLine()) != null){		//P�tla odpowiadaj�ca za wypisanie zawarto�ci pliku 
				linia = odszyfrowanie(linia);			//Wywo�anie funkcji odszyfrowania danych i zapis zwr�conych danych do zmiennej
				System.out.print(linia);			//Wy�wietlenie danych
			}
			Odczyt.close();			//Zamkni�cie dost�pu do pliku
		    System.out.println("*Odczytano z powodzeniem dane z pliku*");			//Informacja o poprawnym odczytaniu danych
		}catch (IOException a) {
			System.out.println("Wyst�pi� b��d podczas pr�by zapisu do pliku");			//Informacja o b�edzie
			a.printStackTrace();
		}
	}
	//funkcja odpowiadaj�ca za szyfrowanie wiadomo�ci
	public static String szyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej kt�ra jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej warto�ci liczbowej podanego znaku
			if(c + przeskok > 122) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
				c =  31 + (przeskok - (122 - c));			//Zmiana wato�ci o podany klucz/przeskok
			}
			else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
				c+=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana warto�ci liczbowej na znak
		}
		return budowniczy.toString();			//Zwr�cenie warto�ci
	}
	//funkcja odpowiadaj�ca za odszyfrowanie wiadomo�ci
	public static String odszyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej kt�ra jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej warto�ci liczbowej podanego znaku
			if(c - przeskok < 32 && c - przeskok != 10 && c - przeskok !=13) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
				c = 123 - (przeskok - (c - 32));			//Zmiana wato�ci o podany klucz/przeskok
			}
			else if(c - przeskok == 10) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				c -=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			else if(c -przeskok == 13) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				c -=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
				c-=przeskok;			//Zmiana wato�ci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana warto�ci liczbowej na znak
		}
		return budowniczy.toString();			//Zwr�cenie warto�ci
	}
	//Funkcja main
	public static void main(String[] args) {
		try {
			File myObj = new File("zapis.txt");			//Utworzenie pliku zapis.txt
			if (myObj.createNewFile()) {			//p�tla sprawdzaj�ca czy plik istnia�
				System.out.println("*Utworzono plik: " + myObj.getName() + "*");			//Wy�wietla dane na ekranie
			} else {
				System.out.println("*Plik istnieje*");			//Wy�wietla dane na ekranie
			}
		}
		catch (IOException b) {
			System.out.println("*Wyst�pi� b��d podczas pr�by stworzenia pliku*");			//Informacja o b�edzie
			b.printStackTrace();
		}
		ArrayList<String> imionalista = new ArrayList<String>();			//Utworzenie listy
		ArrayList<String> nazwiskalista = new ArrayList<String>();			//Utworzenie listy
		ArrayList<Integer> nazwiskalistaint = new ArrayList<Integer>();			//Utworzenie listy
		wizytowka[] obiekt = new wizytowka[101];			//utworzenie tablicy obiekt�w
		Scanner in = new Scanner(System.in);			//Utworzenie zmiennej odpowiadaj�cej za odczyt danych z klawiatury
		Random rand = new Random();			//Utworzenie klasy odpowiadaj�cej za generowanie liczb pseudo losowych
		int losowa;			//zmienna losowa
		int kontrolka=0;			//zmienna kontrolka
		int kontrolkalista=0;			//zmienna kontrolkalista
		int kontrolkababelkowa=0;			//zmienna kontrolkababelkowa
		int danelistaint=0;			//zmienna danelistaint
		int tempint;			//zmienna tempint
		int wielkosclisty;			//zmienna wielkosclisty
		int d_100_w = 0;			//zmienna d_100_w
		String tempstring = new String();			//zmienna tempstring
		String danelistaString = new String();			//zmienna danelistaString
		String[] imiez = new String[] {"Oliwia","Amelia","Maria","Alicja","Lena","Hanna","Zofia","Maja","Julia","Zuzanna"};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] imiem = new String[] {"Adam","Marcel","Stanislaw","Michal","Wiktor","Leon","Piotr","Nikodem","Igor","Ignacy"};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] nazwiskoz = new String[] {"Nowak","Kowalska ","Wisniewska","Wojcik ","Kowalczyk ","Kaminska","Lewandowska","Zielinska","Szymanska","Wozniak"};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] nazwiskom = new String[] {"Nowak","Kowalski ","Wisniewski","Wojcik ","Kowalczyk ","Kaminski","Lewandowski","Zielinski","Szymanski","Wozniak"};			//Utworzenie tablicy i nadanie jej zmiennych
		int[] wartoscintnazwisk = {5,3,7,8,2,1,4,10,6,9};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] n_fy = new String[] {"OPEN","level","focus","over","Echo","signal","ATLAS","AvI","Silver","Solid"};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] a_fy = new String[] {"Przyjaciol","Rozy Wiatrow","Sniadeckich","Jednosci","Kopernika","Tulipanowa","Studecka","Powstania","Europejska","Rondowa"};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] adresmaily = new String[] {"eruqenann-4522@yopmail.com","igavyhinno-6741@yopmail.com","qinnassake-3013@yopmail.com","asolattuk-6557@yopmail.com","abyjeffe-7324@yopmail.com","acellilleb-8662@yopmail.com","ibyddalle-5418@yopmail.com","nemelleha-8414@yopmail.com","ygarrumo-9894@yopmail.com","jyjehoxollo-5788@yopmail.com"};			//Utworzenie tablicy i nadanie jej zmiennych
		String[] prefixy = new String[] {"450","459","500","501","502","503","504","505","506","507","508","509","510","511","512","513","514","515","516","517","518","519","530","531","532","533","534","535","537","538","539","570","572","574","575","576","577","578","600","601","602","603","604","605","606","607","608","609","660","661","662","663","664","665","667","668","669","691","692","693","694","695","696","697","698","721","722","723","724","725","726","730","731","732","733","734","735","738","781","782","784","785","788","790","791","792","794","796","797","798","880","882","885","886","887","888","889"};			//Utworzenie tablicy i nadanie jej zmiennych
		int[] imiezint = {0,0,0,0,0,0,0,0,0,0,0};			//Utworzenie tablicy i nadanie jej zmiennych
		int[] imiemint = {0,0,0,0,0,0,0,0,0,0,0};			//Utworzenie tablicy i nadanie jej zmiennych
		int[] zlicz_imiona = {0,0,0};			//Utworzenie tablicy i nadanie jej zmiennych
		int[] nr_imion = {0,0,0};			//Utworzenie tablicy i nadanie jej zmiennych
		int[] zlicz_imiona_next = {0,0,0};			//Utworzenie tablicy i nadanie jej zmiennych
		String imie = new String();			//Zmienna imie
		String nazwisko = new String();			//Zmienna nazwisko
		String n_f = new String();			//Zmienna firmy
		String a_f = new String();			//Zmienna adres firmy
		String regon = new String();			//Zmienna regon
		String telefon = new String();			//Zmienna numeru
		String adresmail = new String();			//Zmienna adresu mail
		Vector<String> vector = new Vector<>();		//Utworzenie vectora
		do {			//G��wna p�tla w kt�rej s� odwo�ania do innych funkcji
			menu();			//odwo�anie si� do funkcji menu
			kontrolka = in.nextInt();			//Nadanie zmiennej warto�ci z klawiatury
			if(kontrolka==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
				in.nextLine();			//Wywo�anie nowej lini aby pozby� si� zjadanych danych przez nextInt
				System.out.println("Podaj imie :");			//Wy�wietlenie informacji
				imie=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwisko :");			//Wy�wietlenie informacji
				nazwisko=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwe firmy :");			//Wy�wietlenie informacji
				n_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres firmy :");			//Wy�wietlenie informacji
				a_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer regon :");			//Wy�wietlenie informacji
				regon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer telefonu :");			//Wy�wietlenie informacji
				telefon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres email :");			//Wy�wietlenie informacji
				adresmail=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//odwo�anie si� do funkcji zapis_wizytowka oraz w nawiasie wszystkie zmienne kt�re s� przekazane
			}else if(kontrolka==2) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				odczyt_wizytowek();			//odwo�anie si� do funkcji odczyt_wizytowek
			}else if(kontrolka==3) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
					for(int liczba = 0; liczba <= 99;liczba++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
						losowa = rand.nextInt(2);			//Nadanie zmiennej pseudolosowej liczby
						if(losowa > 0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							imie = imiez[losowa];			//Nadanie zmiennej warto�ci z tabeli
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							nazwisko = nazwiskoz[losowa];			//Nadanie zmiennej warto�ci z tabeli
						}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							imie = imiem[losowa];			//Nadanie zmiennej warto�ci z tabeli
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							nazwisko = nazwiskom[losowa];			//Nadanie zmiennej warto�ci z tabeli
						}
						for(int zliczanie=0;zliczanie<=9;zliczanie++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							if(imie == imiez[zliczanie]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
								imiezint[zliczanie] += 1;			//Zwiekszenie warto�ci zmiennej
								imiezint[10] += 1;			//Zwiekszenie warto�ci zmiennej
							}else if(imie == imiem[zliczanie]) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
								imiemint[zliczanie] += 1;			//Zwiekszenie warto�ci zmiennej
								imiemint[10] += 1;			//Zwiekszenie warto�ci zmiennej
							}
						}
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						n_f = n_fy[losowa];			//Nadanie zmiennej warto�ci z tabeli
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						a_f = a_fy[losowa];			//Nadanie zmiennej warto�ci z tabeli
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						regon = "";			//Nadanie zmiennej pustego ci�gu znak�w
						for(int a=1;a<10;a++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							if(a==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
								losowa = rand.nextInt(10)+1;			//Nadanie zmiennej pseudolosowej liczby
								regon = regon+losowa;			//Dodanie do zmiennej nowego ci�gu znak�w
							}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
								losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
								regon = regon+losowa;			//Dodanie do zmiennej nowego ci�gu znak�w
							}
						}
						losowa = rand.nextInt(97);			//Nadanie zmiennej pseudolosowej liczby
						telefon="";			//Nadanie zmiennej pustego ci�gu znak�w
						telefon = telefon + prefixy[losowa];			//Nadanie zmiennej warto�ci z tabeli
						for(int a=1;a<7;a++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
								losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
								telefon = telefon+losowa;			//Dodanie do zmiennej nowego ci�gu znak�w
							}
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						adresmail = adresmaily[losowa];			//Nadanie zmiennej warto�ci z tabeli
						obiekt[liczba] = new wizytowka (liczba+1,imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//Wys�anie danych do kreatora obiektu
						if(obiekt[liczba].imie=="Amelia") {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
							zlicz_imiona[0]+=1;				//inkrementacja warto�ci
						}else if(obiekt[liczba].imie=="Wiktor") {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
							zlicz_imiona[1]+=1;				//inkrementacja warto�ci
						}else if(obiekt[liczba].imie=="Adam") {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
							zlicz_imiona[2]+=1;				//inkrementacja warto�ci
						}
					}
					d_100_w=1;			//Nadanie d_100_w warto�ci 1
			}else if(kontrolka==4) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				losowa = rand.nextInt(2);			//Nadanie zmiennej pseudolosowej liczby
				if(losowa > 0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					imie = imiez[losowa];			//Nadanie zmiennej warto�ci z tabeli
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					nazwisko = nazwiskoz[losowa];			//Nadanie zmiennej warto�ci z tabeli
				}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					imie = imiem[losowa];			//Nadanie zmiennej warto�ci z tabeli
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					nazwisko = nazwiskom[losowa];			//Nadanie zmiennej warto�ci z tabeli
				}
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				n_f = n_fy[losowa];			//Nadanie zmiennej warto�ci z tabeli
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				a_f = a_fy[losowa];			//Nadanie zmiennej warto�ci z tabeli
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				regon = "";			//Nadanie zmiennej pustego ci�gu znak�w
				for(int a=1;a<10;a++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
					if(a==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
						losowa = rand.nextInt(10)+1;			//Nadanie zmiennej pseudolosowej liczby
						regon = regon+losowa;			//Dodanie do zmiennej nowego ci�gu znak�w
					}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						regon = regon+losowa;			//Dodanie do zmiennej nowego ci�gu znak�w
					}
				}
				losowa = rand.nextInt(97);			//Nadanie zmiennej pseudolosowej liczby
				telefon="";			//Nadanie zmiennej pustego ci�gu znak�w
				telefon = telefon + prefixy[losowa];			//Nadanie zmiennej warto�ci z tabeli
				for(int a=1;a<7;a++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						telefon = telefon + losowa;			//Dodanie do zmiennej nowego ci�gu znak�w
					}
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				adresmail = adresmaily[losowa];			//Nadanie zmiennej warto�ci z tabeli
				obiekt[100] = new wizytowka (101,imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//Wys�anie danych do kreatora obiektu
			}else if(kontrolka==5) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				do {			//P�tla odpowiadaj�ca za operacje na li�cie
					menulista();			//Wywo�anie funkcji menulista
					kontrolkalista = in.nextInt();			//Nadanie zmiennej warto�ci z klawiatury
					if(kontrolkalista == 1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
						for(int i=1;i<=100;i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							losowa = rand.nextInt(2);			//Nadanie pseudolosowej liczby
							if(losowa>0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								imionalista.add(imiez[losowa]);			//Utworzenie nowego obiektu listy
							}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								imionalista.add(imiem[losowa]);			//Utworzenie nowego obiektu listy
							}
						}
					}else if(kontrolkalista == 2) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
						for(int zerowanie=0;zerowanie<=10;zerowanie++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							imiezint[zerowanie] = 0;			//Wyzerowanie warto�ci tablicy
							imiemint[zerowanie] = 0;			//Wyzerowanie warto�ci tablicy
						}
						for (int i = 0; i < imionalista.size(); i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							System.out.println(i+1 + " " + imionalista.get(i));			//Wy�wietlanie tekstu w konsoli
							for(int zliczanie=0;zliczanie<=9;zliczanie++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
								if(imionalista.get(i) == imiez[zliczanie]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
									imiezint[zliczanie] += 1;			//Zwiekszenie warto�ci zmiennej
									imiezint[10] += 1;			//Zwiekszenie warto�ci zmiennej
								}else if(imionalista.get(i) == imiem[zliczanie]) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
									imiemint[zliczanie] += 1;			//Zwiekszenie warto�ci zmiennej
									imiemint[10] += 1;			//Zwiekszenie warto�ci zmiennej
								}
							}
						}
						System.out.println("Imion w liscie jest : " + imionalista.size());			//Wy�wietlanie tekstu w konsoli
						for(int i=0;i<10;i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							System.out.println("Imie " + imiez[i] + " powtarza sie " + imiezint[i] + " razy w liscie");			//Wy�wietlanie tekstu w konsoli
						}
						for(int i=0;i<10;i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							System.out.println("Imie " + imiem[i] + " powtarza sie " + imiemint[i] + " razy w liscie");			//Wy�wietlanie tekstu w konsoli
						}
						if(imiezint[10]>imiemint[10]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
							System.out.println("Imion zenskich jest o " + (imiezint[10]-imiemint[10]) + " wiecej niz meskich");			//Wy�wietlanie tekstu w konsoli
						}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
							System.out.println("Imion meskich jest o " + (imiemint[10]-imiezint[10]) + " wiecej niz zenskich");			//Wy�wietlanie tekstu w konsoli
						}
					}else if(kontrolkalista == 3) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
						System.out.println("Podaj ktory element chcesz usunac pamietaj ze wyswietlany przy podgladzie numer musisz obnizyc o 1");			//Wy�wietlanie tekstu w konsoli
						danelistaint=in.nextInt();			//Nadanie wartosci zmiennej
						imionalista.remove(danelistaint);			//Usuniecie zawartosci danej komorki listy
					}else if(kontrolkalista == 4) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
						System.out.println("Podaj jaki element chcesz edytowac");			//Wy�wietlanie tekstu w konsoli
						danelistaint=in.nextInt();			//Nadanie wartosci zmiennej
						System.out.println("Podaj jaki element chcesz edytowac");			//Wy�wietlanie tekstu w konsoli
						in.nextLine();			//Przesuni�cie lini po in.nextInt()
						danelistaString=in.nextLine();			//Wprowadzenie danych do zmiennej
						imionalista.set(danelistaint,danelistaString);			//Zamiana danych w komorce
					}else if(kontrolkalista == 5) {			//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
						imionalista.clear();			//Wyczyszczenie calej listy
					}
				}while(kontrolkalista<6);			//warunek p�tli do (dzia�a je�eli kontrolka jest mniejsza ni� 5)
			}else if(kontrolka==6) {					//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				if(zlicz_imiona[0]==0 && zlicz_imiona[1]==0 && zlicz_imiona[2]==0) {				//Warunek do spe�nienia
					System.out.println("�adne z wybranych imion si� nie pojawia");			//Wy�wietlanie tekstu w konsoli
				}else{				//Ma si� wykona� je�eli wynik if jest b��dny
					System.out.println("Amelia pojawia si� : " + zlicz_imiona[0]);			//Wy�wietlanie tekstu w konsoli
					System.out.println("Wiktor pojawia si� : " + zlicz_imiona[1]);			//Wy�wietlanie tekstu w konsoli
					System.out.println("Adam pojawia si� : " + zlicz_imiona[2]);			//Wy�wietlanie tekstu w konsoli
				}
			}else if(kontrolka==7) {					//Ma si� wykona� je�eli poprzedni warunek okaza� si� fa�szywy ale w odr�nieniu do samego else on sam ma waruek do spe�nienia
				for(int i = 0; i < 10 ; i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
					vector.add(nazwiskom[i]);			//Dodaje losowy element vectora
				}
				System.out.print("Vector : ");			//Wy�wietlanie tekstu w konsoli
				for(int i = 0; i < 10; i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
					if(i<9){				//Warunek do spe�nienia
						System.out.print(vector.get(i) + " , ");			//Wy�wietlanie tekstu w konsoli
					}
					else {				//Ma si� wykona� je�eli wynik if jest b��dny
						System.out.println(vector.get(i));			//Wy�wietlanie tekstu w konsoli
					}	
				}
				vector.remove(rand.nextInt(10));			//Usuwa losowy element vectora
				System.out.print("Vector : ");			//Wy�wietlanie tekstu w konsoli
				for(int i = 0; i < 9; i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
					if(i<8){				//Warunek do spe�nienia
						System.out.print(vector.get(i) + " , ");			//Wy�wietlanie tekstu w konsoli
					}
					else {				//Ma si� wykona� je�eli wynik if jest b��dny
						System.out.println(vector.get(i));			//Wy�wietlanie tekstu w konsoli
					}	
				}
			}else if(kontrolka==8) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
				do{			//P�tla odpowiadaj�ca za operacje na sortowaniu
					menubabelkowa();			//odwo�anie si� do funkcji menu
					kontrolkababelkowa = in.nextInt();			//Nadanie zmiennej warto�ci z klawiatury
					if(kontrolkababelkowa==1) {				//Warunek do spe�nienia
						for(int i=1;i<=100;i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							losowa = rand.nextInt(2);			//Nadanie pseudolosowej liczby
							if(losowa>0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								nazwiskalista.add(nazwiskoz[losowa]);			//Utworzenie nowego obiektu listy
								nazwiskalistaint.add(wartoscintnazwisk[losowa]);			//Utworzenie nowego obiektu listy
							}else {			//Wykonanie czynno�ci je�eli warunek wy�ej oka�e si� b��dny
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								nazwiskalista.add(nazwiskom[losowa]);			//Utworzenie nowego obiektu listy
								nazwiskalistaint.add(wartoscintnazwisk[losowa]);			//Utworzenie nowego obiektu listy
							}
						}
					}else if(kontrolkababelkowa==2) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
						for (int i = 0; i < nazwiskalista.size(); i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							System.out.println(i+1 + " " + nazwiskalista.get(i));			//Wy�wietlanie tekstu w konsoli
						}
					}else if(kontrolkababelkowa==3) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
						wielkosclisty = nazwiskalistaint.size();			//Nadanie warto�ci
						for (int i = 0; i < wielkosclisty-1; i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							for (int j = 0; j < wielkosclisty-i-1; j++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
								if (nazwiskalistaint.get(j) > nazwiskalistaint.get(j+1)) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
									tempint = nazwiskalistaint.get(j);			//Nadanie warto�ci
									tempstring = nazwiskalista.get(j);			//Nadanie warto�ci
									nazwiskalistaint.set(j,nazwiskalistaint.get(j+1));			//Zamiana danych w komorce
									nazwiskalistaint.set(j+1,tempint);			//Zamiana danych w komorce
									nazwiskalista.set(j,nazwiskalista.get(j+1));			//Zamiana danych w komorce
									nazwiskalista.set(j+1,tempstring);			//Zamiana danych w komorce
								}
							}
						}
					}else if(kontrolkababelkowa==4) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
						wielkosclisty = nazwiskalistaint.size();
						for (int i = 0; i < wielkosclisty-1; i++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							for (int j = 0; j < wielkosclisty-i-1; j++) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
								if (nazwiskalistaint.get(j) > nazwiskalistaint.get(j+1)) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
									tempint = nazwiskalistaint.get(j);			//Nadanie warto�ci
									tempstring = nazwiskalista.get(j);			//Nadanie warto�ci
									nazwiskalistaint.set(j,nazwiskalistaint.get(j+1));			//Zamiana danych w komorce
									nazwiskalistaint.set(j+1,tempint);			//Zamiana danych w komorce
									nazwiskalista.set(j,nazwiskalista.get(j+1));			//Zamiana danych w komorce
									nazwiskalista.set(j+1,tempstring);			//Zamiana danych w komorce
									System.out.println(nazwiskalista.get(j) + " -> " + nazwiskalista.get(j+1));				//Wy�wietlanie tekstu w konsoli
									System.out.println(nazwiskalista.get(j+1) + " -> " + nazwiskalista.get(j));				//Wy�wietlanie tekstu w konsoli
								}
							}
						}
					}
				}while(kontrolkababelkowa<5);			//warunek p�tli do (dzia�a je�eli kontrolka jest mniejsza ni� 5)
			}else if(kontrolka==9 && d_100_w==1){			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
				for(int i=1;i<4;i++) {		//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
					System.out.println("Podaj numer " + i + " imienia");				//Wy�wietlanie tekstu w konsoli
					nr_imion[i-1]=in.nextInt();				//Pbranie warto�ci int z klawiatury
				}
				for(int i=0;i<100;i++) {		//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
					for(int j=0;j<3;j++) {		//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
						if(nr_imion[j]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
							if(obiekt[i].imie==imiez[nr_imion[j]]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
								zlicz_imiona_next[j]+=1;				//inkrementacja warto�ci	
							}
						}else if(nr_imion[j]>9) {			//P�tla kt�ra ma dzia�a� dop�ki warunek wskazuje prawd� oraz po warunku jest podana inkrementacja
							if(obiekt[i].imie==imiem[nr_imion[j]-9]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
								zlicz_imiona_next[j]+=1;				//inkrementacja warto�ci
							}
						}
					}	
				}
				if(nr_imion[0]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
					System.out.println("Imie " + imiez[nr_imion[0]] + " pojawia si� : " + zlicz_imiona_next[0] + " razy");				//Wy�wietlanie tekstu w konsoli
				}else{				//Ma si� wykona� je�eli wynik if jest b��dny
					System.out.println("Imie " + imiem[nr_imion[0]-9] + " pojawia si� : " + zlicz_imiona_next[0] + " razy");				//Wy�wietlanie tekstu w konsoli
				}
				if(nr_imion[1]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
					System.out.println("Imie " + imiez[nr_imion[1]] + " pojawia si� : " + zlicz_imiona_next[1] + " razy");				//Wy�wietlanie tekstu w konsoli
				}else{				//Ma si� wykona� je�eli wynik if jest b��dny
					System.out.println("Imie " + imiem[nr_imion[1]-9] + " pojawia si� : " + zlicz_imiona_next[1] + " razy");				//Wy�wietlanie tekstu w konsoli
				}
				if(nr_imion[2]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynno�ci
					System.out.println("Imie " + imiez[nr_imion[2]] + " pojawia si� : " + zlicz_imiona_next[2] + " razy");				//Wy�wietlanie tekstu w konsoli
				}else{				//Ma si� wykona� je�eli wynik if jest b��dny
					System.out.println("Imie " + imiem[nr_imion[2]-9] + " pojawia si� : " + zlicz_imiona_next[2] + " razy");				//Wy�wietlanie tekstu w konsoli
				}
			}
		}while(kontrolka<10);			//warunek p�tli do (dzia�a je�eli kontrolka jest mniejsza ni� 10)
		in.close();			//zamkni�cie strumienia in
	}
}