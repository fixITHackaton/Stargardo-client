fixIT
Instrukcja obsługi aplikacji Stargardo

1.	Repozytorium
Link do repozytorium: https://github.com/fixITHackaton

2.	Struktura projektu
Projekt składa się z trzech modułów:
-Stargardo-host – aplikacja serwera napisana w Java Spring. Odpowiada za logikę backendową i komunikację w bazie danych.
-Stargardo-client – aplikacja klienta napisana na androida w Java
-Stargardo-common – biblioteka zawierająca struktury danych współdzielone przez aplikację klienta i serwera

3.	Konfiguracja
W przypadku używania IDE, należy w nim ustawić jdk na Javę 11.

4.	Budowanie aplikacji
a) W folderze bazowym modułu Stargardo-common wywołać polecenie ‘mvn clean install’ celem zbudowania biblioteki
b) W folderze Stargardo-host wywołać polecenie ‘mvn clean install’ 

5.	Uruchomienie
a)	Najpierw należy odpalić aplikację Stargardo-host – przez IDE lub przez zbudowanego jara.
b)	Należy otworzyć projekt Stargardo-client w programie Android Studio i uruchomić. Aplikacja automatycznie połączy się z serwerem uruchomionym na tej samej maszynie.
