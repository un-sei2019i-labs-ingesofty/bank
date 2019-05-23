#include<stdio.h>
#include<stdlib.h>

using namespace std;

void funcionLaura(int n){
    int factorial;
    if (n==0)
        return 1;
    else
         return n*functionLaura(n-1);
	
}

void funcionValentina(){

}

void funcionDaniel(){
	for (int i = 0; i < count; ++i)
	{
		cout<<i*2<<" ";
	}
	cout<< "funcionDaniel :D"<<endl;
}

int main(){
	funcionLaura();
	funcionValentina();
	funcionDaniel();
}