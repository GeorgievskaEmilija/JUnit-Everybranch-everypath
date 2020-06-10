# Втора лабораториска вежба по Софтверско инженерство
## Емилија Георгиевска, бр. на индекс 183044
### Група на код:  3

### Control Flow Graph  
![alt ControlFlowGraph](https://github.com/GeorgievskaEmilija/SI_lab2_183044/blob/master/img/CFG-183044.png)  
### Цикломатска комплексност   
Цикломатска комплексност = број на предикатни јазли + 1,  9+1 = 10  
Цикломатска комплексност = број на региони - 10  
Цикломатска комплексност = број на јазли - број на темиња + 2, 33 - 25 + 2 = 10   

## Тест случаи според критериумот Every branch  
![alt ControlFlowGraph](https://github.com/GeorgievskaEmilija/SI_lab2_183044/blob/master/img/everybranch.png)  

## Тест случаи според критериумот Every path  
Следни патеки се возможни:
* 1,2 - 3 - 4 - 26 , случај кога user-от е null
ex=assertThrows(RuntimeException.class, () -> lab.function(user1, users));  
assertTrue(ex.getMessage().contains("The user is not instantiated"));  

* 1,2 - 3 - 5 - 6 - 26  
ex=assertThrows(RuntimeException.class, () -> lab.function(user2, users));    
assertTrue(ex.getMessage().contains("The user is missing some mandatory information"));    

* 1,2 - 3 - 5 - 7,8 - 9 -26    
assertFalse( lab.function(user3, users));  

* 1,2 - 3  - 5- 7,8 - 10 -11 -26   
assertFalse(lab.function(user4, users));  

* 1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 17 - 19 - 20 - 14.3 -14.2 - 21- 22 - 23 - 26   
assertFalse(lab.function(user5, users));  

* 1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 17 - 19 - 20 - 14.3 -14.2 - 21- 22 - 24 - 25- 26    
assertFalse(lab.function(user5, users));  

* 1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 16 - 17 - 18 - 19 - 14.3 -14.2 - 21- 22 - 23 - 26  
assertFalse(lab.function(user5, users));  


* 1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 - 16 - 17 - 18 - 19 - 14.3 -14.2 - 21- 22 - 24 - 25 - 26    
assertFalse(lab.function(user5, users));  
 
* 1,2 - 3- 5- 7,8 - 10 - 12,13 - 14.1 - 14.2 - 15 -16- 17 -18- 19 - 20 -14.3 -21 -22 -23 -26  
//FALSE PATH
assertFalse(lab.function(user5, users));  


## Објаснување на напишаните unit tests  
