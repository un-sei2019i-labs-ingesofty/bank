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

void funcionValentina(int n, int m){

if (n>m){
 
	cout<< "El numero mayor es : "<<n<<endl;
}
	else if (n==m)
{
	cout<< "Los numeros son iguales."<<n<<endl;
	
} 	else 

	cout<< "El numero mayor es : "<<m<<endl;


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