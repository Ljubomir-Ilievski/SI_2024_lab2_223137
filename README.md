# Втора лабораториска вежба по Софтверско инженерство


# Љубомир Илиевски, бр. на индекс 223137


2. ![CFG](https://github.com/Ljubomir-Ilievski/SI_2024_lab2_223137/assets/165313312/2da75263-4890-4116-85b4-766d08f6cd05)


3.Цикломацката комплексност 10, пресметано е врз база на број предикатни јазли + 1, или пак по бројот на региони во CFG.

4. Сите потребни тест случаеви кои би ги поминале сите транзиции од еден јазол во друг во кодот се следните 5,

allItems=null, payment=x; ->  Слулжи за да го провери исклучокот кога низата е null.

allItems=[C], payment=x; -> C e item каде нема barcode (null) служи да го тестира овој искллучок

allItems=[B], payment=x; -> B e item каде има невалидиен баркод "1LSFJNM2", служи да го тестира исклучокот за невалиден баркод

allItems=[А,D], payment=800; -> A нема попуст и нема име, D има попуст и исто така баркодот му почиња на 0 и има цена над 300,
овие два објекти прилично служат да ги поминат сите if услови и да врата true со sum<=800

allItems=[A,D], payment=100; -> исто како предходниот случај само да вратат false со sum>100

Тука е прикачена слика со детален приказ во ексел, со точно дефинирани вредности на објектите->
![image](https://github.com/Ljubomir-Ilievski/SI_2024_lab2_223137/assets/165313312/25b99b18-272f-45b6-b228-d41b17b9e312)


5. За да се поминат сите можни случаеви во if условот (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0)
== '0'), Потребно е да се тестира со низата на предмети [F,G,H,I] каде тие се дефинирани соодветно->

	name	barcode  	price	discount
F=	Snack	24892725	25	0
G=	Cake	"04914851"	450	0.25
H=	Cheese	58589158	350	0
I=	Ball	84014857	500	0.1


По детален приказ има на следната слика -> 
![image](https://github.com/Ljubomir-Ilievski/SI_2024_lab2_223137/assets/165313312/8544d07a-1860-4160-ab8f-138bb725fd6f)

6. Тестовите се пишани во две методи:
- checkCart_EveryBranch() -> Се тестира со празна листа па со листа каде елемнт нема баркод, па каде има баркод ама невалиден е
и на крај се тестира со два објекта А и D за точното враќање на true и false од методата соодветно.

- checkCart_multiple_condition() -> се тестира со листа која е точно дефинирана во петтото прашање односно [F,G,H,I],
овие 4 објекти се доволни за секоја комбинација од случаеви да се случи во соодветниот if statement, по мануално правење пресметки за сумата,
добив 507.5, се што треба да провериме е дали сумата е 507.5 и ќе се осигураме за точноста на if statement-от, ова го постигаме со ->

 assertTrue(SILab2.checkCart(multiple_condicion_list, 508));

 assertFalse(SILab2.checkCart(multiple_condicion_list, 507));.
