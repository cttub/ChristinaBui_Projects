
#include <string>
#include <sstream>
#include <iostream>
#include <vector>
#include <fstream>
using namespace std; 
//Christina Bui
int main()
{
    using namespace std;

    ifstream in("PID&PPID.csv"); //calling the csv file

    string line, field;

    //vectors automatically manage storage, consume more memory than an array
    //puts CVS file in 2d Array
    vector< vector<string> > array;  // the 2D array
    vector<string> v;                // array of values for one line only
    vector<int> nodes; 	//array to keep track of nodes

    while ( getline(in,line) )    // get next line in file
    {
        v.clear(); //removes elements
        stringstream ss(line);

        while (getline(ss,field,','))  // break line into comma delimitted fields
        {
            v.push_back(field);  // add each field to the 1D array
        }

        array.push_back(v);  // add the 1D array to the 2D array / pushes elements from the back
    }

    //file pointer
	fstream fout;

	
	//making a graph file
	fout.open("graph.gv",ios::out | ios::app);

	fout << "digraph G {" << "\n";
	fout << "overlap=prism;" << "\n"
		 <<	"overlap_scaling=0.01;" <<"\n"
		 << "ratio=0.7;" << "\n";

	//these are elements to convert array indexes into ints to compare in for loop
	string pid;
	int pID;
	string ppid;
	int pPID;
	string oppid;
	int oPPID;
	string opid;
	int oPID;


	//if we already processed the node into it's child variable
	bool gotNode = false;
	
	//insert the shell pid. This is for the use of a temp variable
	string s = array[0][1];
	stringstream shelly(s);
	int temp = 0;
	int shellID = 0;

	nodes.push_back(0);

	
	for(size_t i=0; i < array.size(); ++i)
	{
				shelly >> temp;
				//this represents the current process's ID on iterator; pID
				pid = array[i][0];
				stringstream PID(pid);
				PID >> pID;
				//this represents the current process's parent ID; pPID
				ppid = array[i][1];
				stringstream PPID(ppid);
				PPID >> pPID;

		for(size_t j=0; j < array.size(); ++j)
		{

			//this represent's other processes' parent ID; oPPID
			oppid = array[j][1];
			stringstream OPPID(oppid);
			OPPID >> oPPID;
			//this represents other process' ID; oPID
			opid = array[j][0];
			stringstream OPID(opid);
			OPID >> oPID;
			

			//for loop to iterate through node array
			for(size_t o = 0; o < nodes.size(); ++o)
			{
				if(pID == nodes[o])
				{
					gotNode = true;
				}
			}

					if(pID != oPID && pID == oPPID && temp != oPID && pPID != shellID && gotNode == false)
					 { 			
						fout << pID << "->" << oPID << "\n"; 
						temp = oPID;	
					}


		}
		//adds node that was already compared to in nodes array
		nodes.push_back(pID);
		gotNode = false;

		//this takes note of the Shell Process ID
		string p = array[0][1];
		stringstream she(s);
		she >> shellID;
	}



	fout << "}" << endl;
    return 0;
}
