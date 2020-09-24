#include  <stdio.h>
#include <sys/types.h>
#include <unistd.h>
using namespace std;
#include <iostream>
#include <fstream>

//Christina Bui
int main(){
	
	//file pointer
	fstream fout;

	fout.open("PID&PPID.csv",ios::out | ios::app);

	int userInput;

	//Process ID & Shell Process ID
	int pid = getpid();
	int parentPID = getppid();

	//Children's ID & Their parent ID
	int pid2;
	int parentPID2;

	cout << "N Input" << endl;
	cin >> userInput; //Get user input from keyboard

	cout << "Process ID: " << pid << endl;
	cout << "Shell Process ID: " << parentPID << endl;


	fout << pid << ","
	<< parentPID <<endl;
	//calls for n amount of times based on user input
	for(int i = 1; i <= userInput; i++){

		fork();
		pid2 = getpid();
		parentPID2 = getppid();

		//parent wait for child to execute
		if(pid == pid2){
			wait(NULL);
		}


		fout <<  pid2 << ", "
		<< parentPID2 
		<<endl;
		

	}

	fout.close();

	

}//end of main