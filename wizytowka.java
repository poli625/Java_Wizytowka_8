package wizytowka;

import java.io.FileWriter;			//Biblioteka odpowiadaj¹ca za obs³uge zapisu do pliku
import java.io.BufferedReader;			//Biblioteka odpowiadaj¹ca za obs³uge zapisu do pliku
import java.io.File;			//Biblioteka odpowiadaj¹ca za obs³uge dostêpu do pliku
import java.io.FileReader;			//Biblioteka odpowiadaj¹ca za obs³uge odczytu z pliku
import java.io.IOException;			//Biblioteka odpowiadaj¹ca za obs³ugê wyj¹tków (try...catch)
import java.time.LocalDateTime;			//Biblioteka odpowiadaj¹ca za odczyt aktualnej daty i czasu
import java.util.ArrayList;			//Biblioteka odpowiadaj¹ca za operacje na listach
import java.util.Random;			//Biblioteka obs³uguj¹ca liczby pseudo losowe
import java.util.Scanner;			//Biblioteka odpowiadaj¹ca za pobieranie danych z klawiatury
import java.util.Vector;			//Biblioteka odpowiadaj¹ca za obs³ugê vectorów

//Patryk Andrzejewski
//U-15565
//Wizytówka

/* Test szyfrowania
String test = "Patryk Andrzejewski";
System.out.println(szyfrowanie(test));
System.out.println(odszyfrowanie(test));
*/

public class wizytowka {			//G³ówna klasa
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
    	this.id = id;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.imie = imie;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.nazwisko = nazwisko;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.n_f = n_f;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.a_f = a_f;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.regon = regon;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.telefon = telefon;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	this.adresmail = adresmail;			//nadanie zmiennej wartoœci otrzymanej przy wywo³aniu kreatora
    	zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//Wywo³anie funkcji zapisu do pliku
    }
	//Funkcja z menu
	public static void menu() {
		System.out.println("Menu programu wizytowka");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
		System.out.println("1. Zapisz dane");			//Wyœwietlanie treœci menu
		System.out.println("2. Odczytaj dane");			//Wyœwietlanie treœci menu
		System.out.println("3. Utwórz losowo 100 wizytowek");			//Wyœwietlanie treœci menu
		System.out.println("4. Utwórz losowo 1 wizytowke");			//Wyœwietlanie treœci menu
		System.out.println("5. Zarzadzanie lista");			//Wyœwietlanie treœci menu
		System.out.println("6. Ilosc 3 imion");			//Wyœwietlanie treœci menu
		System.out.println("7. Vektor");			//Wyœwietlanie treœci menu
		System.out.println("8. Babelkowe");			//Wyœwietlanie treœci menu
		System.out.println("9. Sprawdzenie ile jest wybranych imion");
		System.out.println("10. Zamknij program");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
	}
	public static void menulista() {
		System.out.println("Podmenu lista");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
		System.out.println("1. Utwórz listê 100 losowych imion");			//Wyœwietlanie treœci menu
		System.out.println("2. Wyœwietl listê imion");			//Wyœwietlanie treœci menu
		System.out.println("3. Usun element listy");			//Wyœwietlanie treœci menu
		System.out.println("4. Zamien element listy");			//Wyœwietlanie treœci menu
		System.out.println("5. Wyczysc liste");			//Wyœwietlanie treœci menu
		System.out.println("6. Powrot");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
	}
	public static void menubabelkowa() {
		System.out.println("Podmenu babelkowego");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
		System.out.println("1. Utwórz listê 100 losowych nazwisk");			//Wyœwietlanie treœci menu
		System.out.println("2. Wyœwietl listê nazwisk");			//Wyœwietlanie treœci menu
		System.out.println("3. Dokonaj sortowania");			//Wyœwietlanie treœci menu
		System.out.println("4. Dokonaj sortowania krok po kroku");			//Wyœwietlanie treœci menu
		System.out.println("5. Powrot");			//Wyœwietlanie treœci menu
		System.out.println("-----------------------");			//Wyœwietlanie treœci menu
	}
	//Funkcja odpowiadaj¹ca za dodawanie danych do pliku zapis.txt
	public static void zapis_wizytowka(String imie,String nazwisko,String n_f,String a_f,String regon,String telefon,String adresmail) {
		try {
			FileWriter Zapis = new FileWriter("zapis.txt", true);			//Utworzenie zmiennej zapis która daje dostêp do pliku "zapis.txt" znajduj¹cego siê w folderze z klas¹ oraz nadanie jej atrybutu "true" który odpowiada za dodawanie danych na koñcu pliku zamiast go nadpisywaæ
			imie = (imie + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			imie = szyfrowanie(imie);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(imie);			//Zapis danych do pliku
			nazwisko = (nazwisko + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			nazwisko = szyfrowanie(nazwisko);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(nazwisko);			//Zapis danych do pliku
			n_f = (n_f + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			n_f = szyfrowanie(n_f);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(n_f);			//Zapis danych do pliku
			a_f = (a_f + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			a_f = szyfrowanie(a_f);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(a_f);			//Zapis danych do pliku
			regon = (regon + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			regon = szyfrowanie(regon);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(regon);			//Zapis danych do pliku
			telefon = (telefon + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			telefon = szyfrowanie(telefon);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(telefon);			//Zapis danych do pliku
			adresmail = (adresmail + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			adresmail = szyfrowanie(adresmail);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(adresmail);			//Zapis danych do pliku
			String data = ("Data utworzenia: " + LocalDateTime.now() + "\r\n");			//Dodanie do zmiennej ci¹gu znaku odpowiadaj¹cego za przejœcie do nowej lini
			data = szyfrowanie(data);			//Wywo³anie funkcji szyfrowania danych i zapis zwróconych danych do zmiennej
			Zapis.write(data);			//Zapis aktualnej daty z komputera do pliku
			Zapis.close();			//Zamkniêcie dostêpu do pliku
		}catch (IOException a) {
			System.out.println("*Wyst¹pi³ b³¹d podczas próby zapisu do pliku*");			//Informacja o b³edzie
			a.printStackTrace();
		}
	}
	//Funkcja odpowiadaj¹ca za odczyt danych z pliku zapis.txt
	public static void odczyt_wizytowek() {
		try {
			FileReader Odczyt = new FileReader("zapis.txt");			//Utworzenie zmiennej odczyt która daje dostêp do pliku "zapis.txt" znajduj¹cego siê w folderze z klas¹.
			BufferedReader bodczyt = new BufferedReader(Odczyt);
			String linia;		//Deklaracja zmiennej	
			while ((linia = bodczyt.readLine()) != null){		//Pêtla odpowiadaj¹ca za wypisanie zawartoœci pliku 
				linia = odszyfrowanie(linia);			//Wywo³anie funkcji odszyfrowania danych i zapis zwróconych danych do zmiennej
				System.out.print(linia);			//Wyœwietlenie danych
			}
			Odczyt.close();			//Zamkniêcie dostêpu do pliku
		    System.out.println("*Odczytano z powodzeniem dane z pliku*");			//Informacja o poprawnym odczytaniu danych
		}catch (IOException a) {
			System.out.println("Wyst¹pi³ b³¹d podczas próby zapisu do pliku");			//Informacja o b³edzie
			a.printStackTrace();
		}
	}
	//funkcja odpowiadaj¹ca za szyfrowanie wiadomoœci
	public static String szyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej która jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej wartoœci liczbowej podanego znaku
			if(c + przeskok > 122) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
				c =  31 + (przeskok - (122 - c));			//Zmiana watoœci o podany klucz/przeskok
			}
			else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
				c+=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana wartoœci liczbowej na znak
		}
		return budowniczy.toString();			//Zwrócenie wartoœci
	}
	//funkcja odpowiadaj¹ca za odszyfrowanie wiadomoœci
	public static String odszyfrowanie(String tresc) {
		StringBuilder budowniczy = new StringBuilder(tresc);
		int przeskok = 2;			//utworzenie zmiennej która jest kluczem
		for (int i = 0; i < budowniczy.length(); i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
			int c = (int)budowniczy.charAt(i);			//utworzenie zmiennej i nadanie jej wartoœci liczbowej podanego znaku
			if(c - przeskok < 32 && c - przeskok != 10 && c - przeskok !=13) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
				c = 123 - (przeskok - (c - 32));			//Zmiana watoœci o podany klucz/przeskok
			}
			else if(c - przeskok == 10) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				c -=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			else if(c -przeskok == 13) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				c -=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
				c-=przeskok;			//Zmiana watoœci o podany klucz/przeskok
			}
			budowniczy.setCharAt(i, (char)c);			//zmiana wartoœci liczbowej na znak
		}
		return budowniczy.toString();			//Zwrócenie wartoœci
	}
	//Funkcja main
	public static void main(String[] args) {
		try {
			File myObj = new File("zapis.txt");			//Utworzenie pliku zapis.txt
			if (myObj.createNewFile()) {			//pêtla sprawdzaj¹ca czy plik istnia³
				System.out.println("*Utworzono plik: " + myObj.getName() + "*");			//Wyœwietla dane na ekranie
			} else {
				System.out.println("*Plik istnieje*");			//Wyœwietla dane na ekranie
			}
		}
		catch (IOException b) {
			System.out.println("*Wyst¹pi³ b³¹d podczas próby stworzenia pliku*");			//Informacja o b³edzie
			b.printStackTrace();
		}
		ArrayList<String> imionalista = new ArrayList<String>();			//Utworzenie listy
		ArrayList<String> nazwiskalista = new ArrayList<String>();			//Utworzenie listy
		ArrayList<Integer> nazwiskalistaint = new ArrayList<Integer>();			//Utworzenie listy
		wizytowka[] obiekt = new wizytowka[101];			//utworzenie tablicy obiektów
		Scanner in = new Scanner(System.in);			//Utworzenie zmiennej odpowiadaj¹cej za odczyt danych z klawiatury
		Random rand = new Random();			//Utworzenie klasy odpowiadaj¹cej za generowanie liczb pseudo losowych
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
		do {			//G³ówna pêtla w której s¹ odwo³ania do innych funkcji
			menu();			//odwo³anie siê do funkcji menu
			kontrolka = in.nextInt();			//Nadanie zmiennej wartoœci z klawiatury
			if(kontrolka==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
				in.nextLine();			//Wywo³anie nowej lini aby pozbyæ siê zjadanych danych przez nextInt
				System.out.println("Podaj imie :");			//Wyœwietlenie informacji
				imie=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwisko :");			//Wyœwietlenie informacji
				nazwisko=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj nazwe firmy :");			//Wyœwietlenie informacji
				n_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres firmy :");			//Wyœwietlenie informacji
				a_f=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer regon :");			//Wyœwietlenie informacji
				regon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj numer telefonu :");			//Wyœwietlenie informacji
				telefon=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				System.out.println("Podaj adres email :");			//Wyœwietlenie informacji
				adresmail=in.nextLine();			//Uzyskanie danych z klawiatury i wprowadzenie ich do zmiennej
				zapis_wizytowka(imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//odwo³anie siê do funkcji zapis_wizytowka oraz w nawiasie wszystkie zmienne które s¹ przekazane
			}else if(kontrolka==2) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				odczyt_wizytowek();			//odwo³anie siê do funkcji odczyt_wizytowek
			}else if(kontrolka==3) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
					for(int liczba = 0; liczba <= 99;liczba++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
						losowa = rand.nextInt(2);			//Nadanie zmiennej pseudolosowej liczby
						if(losowa > 0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							imie = imiez[losowa];			//Nadanie zmiennej wartoœci z tabeli
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							nazwisko = nazwiskoz[losowa];			//Nadanie zmiennej wartoœci z tabeli
						}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							imie = imiem[losowa];			//Nadanie zmiennej wartoœci z tabeli
							losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
							nazwisko = nazwiskom[losowa];			//Nadanie zmiennej wartoœci z tabeli
						}
						for(int zliczanie=0;zliczanie<=9;zliczanie++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							if(imie == imiez[zliczanie]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
								imiezint[zliczanie] += 1;			//Zwiekszenie wartoœci zmiennej
								imiezint[10] += 1;			//Zwiekszenie wartoœci zmiennej
							}else if(imie == imiem[zliczanie]) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
								imiemint[zliczanie] += 1;			//Zwiekszenie wartoœci zmiennej
								imiemint[10] += 1;			//Zwiekszenie wartoœci zmiennej
							}
						}
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						n_f = n_fy[losowa];			//Nadanie zmiennej wartoœci z tabeli
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						a_f = a_fy[losowa];			//Nadanie zmiennej wartoœci z tabeli
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						regon = "";			//Nadanie zmiennej pustego ci¹gu znaków
						for(int a=1;a<10;a++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							if(a==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
								losowa = rand.nextInt(10)+1;			//Nadanie zmiennej pseudolosowej liczby
								regon = regon+losowa;			//Dodanie do zmiennej nowego ci¹gu znaków
							}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
								losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
								regon = regon+losowa;			//Dodanie do zmiennej nowego ci¹gu znaków
							}
						}
						losowa = rand.nextInt(97);			//Nadanie zmiennej pseudolosowej liczby
						telefon="";			//Nadanie zmiennej pustego ci¹gu znaków
						telefon = telefon + prefixy[losowa];			//Nadanie zmiennej wartoœci z tabeli
						for(int a=1;a<7;a++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
								losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
								telefon = telefon+losowa;			//Dodanie do zmiennej nowego ci¹gu znaków
							}
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						adresmail = adresmaily[losowa];			//Nadanie zmiennej wartoœci z tabeli
						obiekt[liczba] = new wizytowka (liczba+1,imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//Wys³anie danych do kreatora obiektu
						if(obiekt[liczba].imie=="Amelia") {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
							zlicz_imiona[0]+=1;				//inkrementacja wartoœci
						}else if(obiekt[liczba].imie=="Wiktor") {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
							zlicz_imiona[1]+=1;				//inkrementacja wartoœci
						}else if(obiekt[liczba].imie=="Adam") {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
							zlicz_imiona[2]+=1;				//inkrementacja wartoœci
						}
					}
					d_100_w=1;			//Nadanie d_100_w wartoœci 1
			}else if(kontrolka==4) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				losowa = rand.nextInt(2);			//Nadanie zmiennej pseudolosowej liczby
				if(losowa > 0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					imie = imiez[losowa];			//Nadanie zmiennej wartoœci z tabeli
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					nazwisko = nazwiskoz[losowa];			//Nadanie zmiennej wartoœci z tabeli
				}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					imie = imiem[losowa];			//Nadanie zmiennej wartoœci z tabeli
					losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
					nazwisko = nazwiskom[losowa];			//Nadanie zmiennej wartoœci z tabeli
				}
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				n_f = n_fy[losowa];			//Nadanie zmiennej wartoœci z tabeli
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				a_f = a_fy[losowa];			//Nadanie zmiennej wartoœci z tabeli
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				regon = "";			//Nadanie zmiennej pustego ci¹gu znaków
				for(int a=1;a<10;a++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
					if(a==1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
						losowa = rand.nextInt(10)+1;			//Nadanie zmiennej pseudolosowej liczby
						regon = regon+losowa;			//Dodanie do zmiennej nowego ci¹gu znaków
					}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						regon = regon+losowa;			//Dodanie do zmiennej nowego ci¹gu znaków
					}
				}
				losowa = rand.nextInt(97);			//Nadanie zmiennej pseudolosowej liczby
				telefon="";			//Nadanie zmiennej pustego ci¹gu znaków
				telefon = telefon + prefixy[losowa];			//Nadanie zmiennej wartoœci z tabeli
				for(int a=1;a<7;a++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
						losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
						telefon = telefon + losowa;			//Dodanie do zmiennej nowego ci¹gu znaków
					}
				losowa = rand.nextInt(10);			//Nadanie zmiennej pseudolosowej liczby
				adresmail = adresmaily[losowa];			//Nadanie zmiennej wartoœci z tabeli
				obiekt[100] = new wizytowka (101,imie,nazwisko,n_f,a_f,regon,telefon,adresmail);			//Wys³anie danych do kreatora obiektu
			}else if(kontrolka==5) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				do {			//Pêtla odpowiadaj¹ca za operacje na liœcie
					menulista();			//Wywo³anie funkcji menulista
					kontrolkalista = in.nextInt();			//Nadanie zmiennej wartoœci z klawiatury
					if(kontrolkalista == 1) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
						for(int i=1;i<=100;i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							losowa = rand.nextInt(2);			//Nadanie pseudolosowej liczby
							if(losowa>0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								imionalista.add(imiez[losowa]);			//Utworzenie nowego obiektu listy
							}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								imionalista.add(imiem[losowa]);			//Utworzenie nowego obiektu listy
							}
						}
					}else if(kontrolkalista == 2) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
						for(int zerowanie=0;zerowanie<=10;zerowanie++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							imiezint[zerowanie] = 0;			//Wyzerowanie wartoœci tablicy
							imiemint[zerowanie] = 0;			//Wyzerowanie wartoœci tablicy
						}
						for (int i = 0; i < imionalista.size(); i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							System.out.println(i+1 + " " + imionalista.get(i));			//Wyœwietlanie tekstu w konsoli
							for(int zliczanie=0;zliczanie<=9;zliczanie++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
								if(imionalista.get(i) == imiez[zliczanie]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
									imiezint[zliczanie] += 1;			//Zwiekszenie wartoœci zmiennej
									imiezint[10] += 1;			//Zwiekszenie wartoœci zmiennej
								}else if(imionalista.get(i) == imiem[zliczanie]) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
									imiemint[zliczanie] += 1;			//Zwiekszenie wartoœci zmiennej
									imiemint[10] += 1;			//Zwiekszenie wartoœci zmiennej
								}
							}
						}
						System.out.println("Imion w liscie jest : " + imionalista.size());			//Wyœwietlanie tekstu w konsoli
						for(int i=0;i<10;i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							System.out.println("Imie " + imiez[i] + " powtarza sie " + imiezint[i] + " razy w liscie");			//Wyœwietlanie tekstu w konsoli
						}
						for(int i=0;i<10;i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							System.out.println("Imie " + imiem[i] + " powtarza sie " + imiemint[i] + " razy w liscie");			//Wyœwietlanie tekstu w konsoli
						}
						if(imiezint[10]>imiemint[10]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
							System.out.println("Imion zenskich jest o " + (imiezint[10]-imiemint[10]) + " wiecej niz meskich");			//Wyœwietlanie tekstu w konsoli
						}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
							System.out.println("Imion meskich jest o " + (imiemint[10]-imiezint[10]) + " wiecej niz zenskich");			//Wyœwietlanie tekstu w konsoli
						}
					}else if(kontrolkalista == 3) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
						System.out.println("Podaj ktory element chcesz usunac pamietaj ze wyswietlany przy podgladzie numer musisz obnizyc o 1");			//Wyœwietlanie tekstu w konsoli
						danelistaint=in.nextInt();			//Nadanie wartosci zmiennej
						imionalista.remove(danelistaint);			//Usuniecie zawartosci danej komorki listy
					}else if(kontrolkalista == 4) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
						System.out.println("Podaj jaki element chcesz edytowac");			//Wyœwietlanie tekstu w konsoli
						danelistaint=in.nextInt();			//Nadanie wartosci zmiennej
						System.out.println("Podaj jaki element chcesz edytowac");			//Wyœwietlanie tekstu w konsoli
						in.nextLine();			//Przesuniêcie lini po in.nextInt()
						danelistaString=in.nextLine();			//Wprowadzenie danych do zmiennej
						imionalista.set(danelistaint,danelistaString);			//Zamiana danych w komorce
					}else if(kontrolkalista == 5) {			//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
						imionalista.clear();			//Wyczyszczenie calej listy
					}
				}while(kontrolkalista<6);			//warunek pêtli do (dzia³a je¿eli kontrolka jest mniejsza ni¿ 5)
			}else if(kontrolka==6) {					//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				if(zlicz_imiona[0]==0 && zlicz_imiona[1]==0 && zlicz_imiona[2]==0) {				//Warunek do spe³nienia
					System.out.println("¯adne z wybranych imion siê nie pojawia");			//Wyœwietlanie tekstu w konsoli
				}else{				//Ma siê wykonaæ je¿eli wynik if jest b³êdny
					System.out.println("Amelia pojawia siê : " + zlicz_imiona[0]);			//Wyœwietlanie tekstu w konsoli
					System.out.println("Wiktor pojawia siê : " + zlicz_imiona[1]);			//Wyœwietlanie tekstu w konsoli
					System.out.println("Adam pojawia siê : " + zlicz_imiona[2]);			//Wyœwietlanie tekstu w konsoli
				}
			}else if(kontrolka==7) {					//Ma siê wykonaæ je¿eli poprzedni warunek okaza³ siê fa³szywy ale w odró¿nieniu do samego else on sam ma waruek do spe³nienia
				for(int i = 0; i < 10 ; i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
					vector.add(nazwiskom[i]);			//Dodaje losowy element vectora
				}
				System.out.print("Vector : ");			//Wyœwietlanie tekstu w konsoli
				for(int i = 0; i < 10; i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
					if(i<9){				//Warunek do spe³nienia
						System.out.print(vector.get(i) + " , ");			//Wyœwietlanie tekstu w konsoli
					}
					else {				//Ma siê wykonaæ je¿eli wynik if jest b³êdny
						System.out.println(vector.get(i));			//Wyœwietlanie tekstu w konsoli
					}	
				}
				vector.remove(rand.nextInt(10));			//Usuwa losowy element vectora
				System.out.print("Vector : ");			//Wyœwietlanie tekstu w konsoli
				for(int i = 0; i < 9; i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
					if(i<8){				//Warunek do spe³nienia
						System.out.print(vector.get(i) + " , ");			//Wyœwietlanie tekstu w konsoli
					}
					else {				//Ma siê wykonaæ je¿eli wynik if jest b³êdny
						System.out.println(vector.get(i));			//Wyœwietlanie tekstu w konsoli
					}	
				}
			}else if(kontrolka==8) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
				do{			//Pêtla odpowiadaj¹ca za operacje na sortowaniu
					menubabelkowa();			//odwo³anie siê do funkcji menu
					kontrolkababelkowa = in.nextInt();			//Nadanie zmiennej wartoœci z klawiatury
					if(kontrolkababelkowa==1) {				//Warunek do spe³nienia
						for(int i=1;i<=100;i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							losowa = rand.nextInt(2);			//Nadanie pseudolosowej liczby
							if(losowa>0) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								nazwiskalista.add(nazwiskoz[losowa]);			//Utworzenie nowego obiektu listy
								nazwiskalistaint.add(wartoscintnazwisk[losowa]);			//Utworzenie nowego obiektu listy
							}else {			//Wykonanie czynnoœci je¿eli warunek wy¿ej oka¿e siê b³êdny
								losowa = rand.nextInt(10);			//Nadanie pseudolosowej liczby
								nazwiskalista.add(nazwiskom[losowa]);			//Utworzenie nowego obiektu listy
								nazwiskalistaint.add(wartoscintnazwisk[losowa]);			//Utworzenie nowego obiektu listy
							}
						}
					}else if(kontrolkababelkowa==2) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
						for (int i = 0; i < nazwiskalista.size(); i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							System.out.println(i+1 + " " + nazwiskalista.get(i));			//Wyœwietlanie tekstu w konsoli
						}
					}else if(kontrolkababelkowa==3) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
						wielkosclisty = nazwiskalistaint.size();			//Nadanie wartoœci
						for (int i = 0; i < wielkosclisty-1; i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							for (int j = 0; j < wielkosclisty-i-1; j++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
								if (nazwiskalistaint.get(j) > nazwiskalistaint.get(j+1)) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
									tempint = nazwiskalistaint.get(j);			//Nadanie wartoœci
									tempstring = nazwiskalista.get(j);			//Nadanie wartoœci
									nazwiskalistaint.set(j,nazwiskalistaint.get(j+1));			//Zamiana danych w komorce
									nazwiskalistaint.set(j+1,tempint);			//Zamiana danych w komorce
									nazwiskalista.set(j,nazwiskalista.get(j+1));			//Zamiana danych w komorce
									nazwiskalista.set(j+1,tempstring);			//Zamiana danych w komorce
								}
							}
						}
					}else if(kontrolkababelkowa==4) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
						wielkosclisty = nazwiskalistaint.size();
						for (int i = 0; i < wielkosclisty-1; i++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							for (int j = 0; j < wielkosclisty-i-1; j++) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
								if (nazwiskalistaint.get(j) > nazwiskalistaint.get(j+1)) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
									tempint = nazwiskalistaint.get(j);			//Nadanie wartoœci
									tempstring = nazwiskalista.get(j);			//Nadanie wartoœci
									nazwiskalistaint.set(j,nazwiskalistaint.get(j+1));			//Zamiana danych w komorce
									nazwiskalistaint.set(j+1,tempint);			//Zamiana danych w komorce
									nazwiskalista.set(j,nazwiskalista.get(j+1));			//Zamiana danych w komorce
									nazwiskalista.set(j+1,tempstring);			//Zamiana danych w komorce
									System.out.println(nazwiskalista.get(j) + " -> " + nazwiskalista.get(j+1));				//Wyœwietlanie tekstu w konsoli
									System.out.println(nazwiskalista.get(j+1) + " -> " + nazwiskalista.get(j));				//Wyœwietlanie tekstu w konsoli
								}
							}
						}
					}
				}while(kontrolkababelkowa<5);			//warunek pêtli do (dzia³a je¿eli kontrolka jest mniejsza ni¿ 5)
			}else if(kontrolka==9 && d_100_w==1){			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
				for(int i=1;i<4;i++) {		//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
					System.out.println("Podaj numer " + i + " imienia");				//Wyœwietlanie tekstu w konsoli
					nr_imion[i-1]=in.nextInt();				//Pbranie wartoœci int z klawiatury
				}
				for(int i=0;i<100;i++) {		//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
					for(int j=0;j<3;j++) {		//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
						if(nr_imion[j]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
							if(obiekt[i].imie==imiez[nr_imion[j]]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
								zlicz_imiona_next[j]+=1;				//inkrementacja wartoœci	
							}
						}else if(nr_imion[j]>9) {			//Pêtla która ma dzia³aæ dopóki warunek wskazuje prawdê oraz po warunku jest podana inkrementacja
							if(obiekt[i].imie==imiem[nr_imion[j]-9]) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
								zlicz_imiona_next[j]+=1;				//inkrementacja wartoœci
							}
						}
					}	
				}
				if(nr_imion[0]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
					System.out.println("Imie " + imiez[nr_imion[0]] + " pojawia siê : " + zlicz_imiona_next[0] + " razy");				//Wyœwietlanie tekstu w konsoli
				}else{				//Ma siê wykonaæ je¿eli wynik if jest b³êdny
					System.out.println("Imie " + imiem[nr_imion[0]-9] + " pojawia siê : " + zlicz_imiona_next[0] + " razy");				//Wyœwietlanie tekstu w konsoli
				}
				if(nr_imion[1]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
					System.out.println("Imie " + imiez[nr_imion[1]] + " pojawia siê : " + zlicz_imiona_next[1] + " razy");				//Wyœwietlanie tekstu w konsoli
				}else{				//Ma siê wykonaæ je¿eli wynik if jest b³êdny
					System.out.println("Imie " + imiem[nr_imion[1]-9] + " pojawia siê : " + zlicz_imiona_next[1] + " razy");				//Wyœwietlanie tekstu w konsoli
				}
				if(nr_imion[2]<10) {			//Sprawdzanie czy warunek jest poprawny i w razie prawdy wykonuje czynnoœci
					System.out.println("Imie " + imiez[nr_imion[2]] + " pojawia siê : " + zlicz_imiona_next[2] + " razy");				//Wyœwietlanie tekstu w konsoli
				}else{				//Ma siê wykonaæ je¿eli wynik if jest b³êdny
					System.out.println("Imie " + imiem[nr_imion[2]-9] + " pojawia siê : " + zlicz_imiona_next[2] + " razy");				//Wyœwietlanie tekstu w konsoli
				}
			}
		}while(kontrolka<10);			//warunek pêtli do (dzia³a je¿eli kontrolka jest mniejsza ni¿ 10)
		in.close();			//zamkniêcie strumienia in
	}
}