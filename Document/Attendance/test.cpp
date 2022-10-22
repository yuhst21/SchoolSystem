#include <iostream>
#include <math.h>
using namespace std;
int s[90];

int ucln(int a, int b)
{
    if ((a == 0) || (b == 0))
        return a+b;
    while (a!=b){
       if(a>b)
          a=a-b;
       else
          b=b-a;
    }
    return a;

}

int dao(int x)
{
    int y=0;
    y=((x%10)*10)+(x/10);
    return y;
}

int timso()
{
    int d = 0;
    for(int x=10;x<100;x++)
    {
            if(ucln(x,dao(x))==1)
            {
                    s[d++]=x;
            }
    }
    return d;
}

void KetQua()
{
    int n = timso();
     for(int i=0;i<n;i++)
     {
             cout<< s[i] << " ";
     }
}

int main()
{

    KetQua();

}
