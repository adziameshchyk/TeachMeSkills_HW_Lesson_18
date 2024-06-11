# Multithreading
>This repository was created for homework in lessons №18 - "Multithreading".
## Tasks

### Mandatory task:  
0.  Create three streams T1, T2 and T3  
	Implement the execution of the flow in the sequence T3 -> T2 -> T1  
	(using join method)  

1.  Create a program that simulates morning: reading the news, tomorrow, coffee.  
	Give each thread a name and priority from the config file. Let the name and priority of the thread be specified through the properties file.  
	Let there be 3 threads.  
	Create and run 3 threads  

### Extra credit task:  
2.	There is a service station. A service station can have a maximum of a certain number of cars in service.  
	Create a class that will run in a separate thread and will add cars for service at the service station.  
	Create a class that will run in a separate thread and will pick up fixed cars from the service station.  
	Let the maximum number of machines available for service be specified through the properties file.  
	Use synchronized, wait, notify.  
	
### Very difficult task:
3.  Write a multi-threaded bounded buffer using ReentrantLock.	  

4.  Write a multi-threaded bounded buffer using synchronized.  
