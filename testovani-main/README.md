# Testování softwaru (TS1) - stránka s domácími úkoly

## Cvičící: Václav Smítka
## Autor:  Aleksandr Kross


### 1. DU - Faktorial Test ✅

Vytvořte projekt ts1-lab02, group id je cz.cvut.fel.ts1.

Vytvořte třídu <Username> v balíčku cz.fel.cvut.ts1 s public metodou: public long factorial (int n).
Metoda je veřejná,vrací long a bere int n jako argument. Metoda počítá a vrací n! (faktoriál).

Vytvořte třídu <Username>Test.
Bude také v balíčku jménem cz.fel.cvut.ts1, ale v adresáři test/java a ne main/java.
V této třídě si uděláme test pro testování metody factorial, jménem factorialTest.

Student 1: 
- Přidejte si kolegu jako Maintainera (Settings → Members → Invite member).
- Nezapomeňte také do projektu přidat svého cvičícího.

Student 2: 
- Naklonujte si projekt do kterého jste byli přidáni. (git clone ...)
- Vytvořte v něm novou větev. (git checkout -b “Adds new factorial impl.”)
- Přidejte metodu která počítá faktoriál.
- Pushněte novou větev. (git push)

Student 1: 
- Poté co Vám kolega pushne novou větev přepněte se do ní (git checkout)
- Doplňte do projektu test(y) metody faktoriálu a nahrajte do repozitáře
- Všechny změny zmergujte do master větve.


[Odkaz na main](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/hw1)<br>
[Odkaz na Unit testy](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/test/java/cz/cvut/fel/ts1/hw1)


### 2. DU - Calculator Test ✅

K tomu nám poslouží jednoduchá celočíselná kalkulačka, která bude umět základní funkce, tedy sčítat, odčítat, násobit a dělit.

Vytvořte k tomuto účelu v adresáři src/main/java balíček hw2, v něm třídu Calculator a implementujte metody:
- sum
- subtract
- multiply
- divide

Ve vytvořeném projektu kalkulačky vytvořte třídu CalculatorTest a přidejte do ni pro každou metodu kalkulačky jeden test.
Vytvořte i test pro případ, kdy je do metody pro dělení vložena do jmenovatele nula. Použijte assert, který očekává vyhození
výjimky.

Hotový projekt kalkulačky v mavenu s testovací třídou poté pushněte do vašeho vzdáleného repozitáře.

[Odkaz na main](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/hw2)<br>
[Odkaz na Unit testy](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/test/java/cz/cvut/fel/ts1/hw2)


### 3. DU - Test na Moodlu ✅

Vyplňte TEST na Moodlu.


### 4. DU - Jednotkové a procesní testy ✅

**Odevzdávejte do vlastního repozitáře do nového adresáře. **

Ze zdrojových kódů v archivu vytvořte nový Maven projekt.

Pomocí jednotkových testů v jUnit otestujte následující třídy:

**StandardItem**
konstruktor, copy, parametrizovaný test pro equals

**Order**
konstruktory - nezapomeňte na null hodnoty

**ItemStock**
konstruktor, parametrizovaný test pro metody změny počtu

**PurchasesArchive**
- testy metod printItemPurchaseStatistics, getHowManyTimesHasBeenItemSold a putOrderToPurchasesArchive
- println (stream)
- mock orderArchive
- mock ItemPurchaseArchiveEntry
- ověřte správné volání konstruktoru při vytvoření ItemPurchaseArchiveEntry

**Proveďte analýzu a vytvořte procesní testy pro třídu EShopController.**<br>
Pokryjte proces naplnění košíku a jeho nákup, včetně souvisejících podprocesů(ošetření skladových zásob, archivace nákupů). Berte v úvahu také:
- varianty kroků procesu (např. odebrání zboží z košíku)
- chybové stavy (např. nedostatek zboží na skladě)

Pozor na rozdíl mezi procesním/integračním a jednotkovým testem!

Pokud narazíte na problémy nebo chyby v kódu, zdrojový kód použitých tříd můžete dle potřeby upravit.

[Odkaz na main](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/hw4)<br>
[Odkaz na Unit testy](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/test/java/cz/cvut/fel/ts1/hw2)


### 5. DU - Párové testování ✅

Metodou párového testování vytvořte testovací scénáře pro systém pro rezervaci letenek ze třetího cvičení. 
Doporučujeme využít některý z předvedených nástrojů (ACTS nebo Allpairs).

Řešení odevzdejte prostřednictvím svého repozitáře, ve kterém vytvořte novou složku cv06-pairwise. 
Do ní pak nahrajte výsledné testovací scénáře (např jako CSV soubor) a případně všechny další soubory reprezentující zdrojový  systém (v ACTS nástroji XML soubor, v Allpairs XLS / TXT).

[Odkaz na řesení](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/cv06-pairwise)<br>


### 6. DU - navrh procesních testů ✅

UML diagram aktivit (Slajd 29, cvičení 8) převeďte na orientovaný graf s větvícími body a přechody mezi nimi.

Ručně vygenerujte průchody v aplikací pro procesní testy s pokrytím TDL=1 a TDL=2.

Nástrojem Oxygen vygenerujte procesy s TDL=3.

Soubor/fotku s orientovaným grafem, ručně vygenerovanými průchody a CSV soubor s průchody generovanými aplikací Oxygen odevzdejte do souboru cv07-processve svém repozitáři.

[Odkaz na řesení](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/cv07-process)<br>




### 7. DU - Selenium ✅
**Vytvořte nový maven projekt ve kterém připravte Selenium Page Object Model třídy s pomocí Page Factory které budou pracovat se stránkou https://link.springer.com/.** <br>

**Připravte Page Object Model pro stránky:** <br>

https://link.springer.com/    -k přesunu na přihlašovací obrazovku a pokročilé vyhledávání <br>

https://link.springer.com/signup-login    -k přihlášení <br>

https://link.springer.com/advanced-search     -pro pokročilé vyhledávání, tedy práci s formulářem <br>

https://link.springer.com/search    -pro procházení výsledků vyhledávání <br>

https://link.springer.com/article/     -pro čtení článku <br>

Připravte program, který vyhledá na link.springer.com všechny články(Content type = Article) obsahující slova “Page Object Model” a alespoň jedním ze slov “Sellenium Testing” publikovaných v tomto roce. Poté přečte první čtyři články a uložte si jejich Název, DOI a datum publikace. Napište parametrizované testy pomocí vytvořených Page Object Modelů, které Vás přihlásí jako uživatele a vyhledávají uložené články (pomocí jejich názvu) a zkontrolují, že odpovídá jejich datum publikace a DOI. <br>

[Odkaz na main](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/hw7)<br>
[Odkaz na testy](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/test/java/cz/cvut/fel/ts1/hw7)


## Aktivity

### 1. Cviceni - Úvod, organizace předmětu, infrastruktura (ide, jdk, mvn, git).
[]()

### 2. Cviceni - Vytvoření git repozitáře ✅
[Odkaz na Git](https://gitlab.fel.cvut.cz/krossale/testovani)

### 3. Cviceni - Techniky návrhu testů. Kombinace vstupů - mezní podmínky, třídy ekvivalence  ✅
[Techniky návrhu testů: Kombinace vstupů - mezní podmínky, třídy ekvivalence](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/cv03-tridy_ekvivalence)

### 4. Cviceni - Unit testy, refaktoring
[]()

### 5. Cviceni - Unit testy - parametrizace, refaktoring, mockování
[]()

### 6. Cviceni - Techniky návrhu testů: Kombinace vstupů, Pairwise testing
[]()

### 7. Cviceni - Techniky návrhu testů: Procesní testy
[]()

### 8. Cviceni - Techniky pro návrh testovacích scénářů: Životní cyklus datových objektů  ✅

**Navrhněte testovací scénáře pro systém správy letů a rezervace letenek.**

CRUD matice není k dispozici, máme jen přehled datových entit a funkcí nad nimi.

| **     ** | **Letiště** | **Let** | **Letadlo** | **Letenka** | **Pasažér** |
| ------ | ------ | ------ | ------ | ------ | ------ |
| Přeplánování letu na jiný čas |        |        |        |        |        |
| Přesun pasažéra do jiného letu |        |        |        |        |        |
| Výpis údajů o letu a seznam pasažérů |        |        |        |        |        |
| Přehled pokrytí letišť lety |        |        |        |        |        |
| Změň letadlo v naplánovaných letech |        |        |        |        |        |
| Tisk letového itineráře pro pasažéra |        |        |        |        |        |
| Přesměruj nebo zruš lety, pokud je letiště nedostupné |        |        |        |        |        |
| Výpis detailů letadla a přehled jeho letů |        |        |        |        |        |
| Seznam letadel a přehled jejich vytíženosti |        |        |        |        |        |


[Odkaz na reseni](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/main/java/cz/cvut/fel/ts1/cv09-crud)

### 9. Cviceni - Selenium úvod
[]()

### 10. Cviceni - Selenium pokračování
[]()

### 11. Cviceni - Selenium automatizace.  ✅ 
Aktivity: Test Robot

Byl vytvořen Selenium-test, který zadává data do formuláře.

**Aleksandr Kross 101C**<br>
**86400**<br>
**Oberon**<br>
**Rumunsko**<br>

[Odkaz na reseni](https://gitlab.fel.cvut.cz/krossale/testovani/-/tree/main/src/test/java/cz/cvut/fel/ts1/cviceni_11)

