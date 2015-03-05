|====================================
| Project Euler, problem 54 - Poker |
|                                   |
|                Standa Novák, 2011 |
====================================|

Hlavním bodem programu je třída Main obsahující metodu main. Tato metoda načte
rozdání karet ze souboru, porovná mezi sebou všechny dvojice a vypíše na výstup,
kolikrát vyhrál první hráč.

Karta je reprezentována třídou Card. Obsahuje konstruktor, který z dvojznakového
stringu ("9C") vyrobí kartu (devítka křížová). Typy karet (piky, káry, kříže,
srdce) jsou popsány jako výčtový typ CardSuit. Pětice karet pak tvoří rozdání
reprezentováno třídou Hand.

Rozdání načítá ze souboru statická metoda loadHands() třídy HandsLoader.

Aby bylo možné porovnat, který hráč vyhrál, je zapotřebí v třídě Hand definovat
metodu compareTo. Tato metoda vytvoří pro rozdání karet obou hráčů objekt typu
HandValuator, který poskytne o obou rozdání informace o hodnotě jako objekt typu
HandValue. Třída HandValue je Comparable, takže se její prvky dají jednoduše
porovnat.

Samotné porovnání pak zajišťuje třída HandValuator zapomocí valuátorů z balíku
problem54_poker.valuator.