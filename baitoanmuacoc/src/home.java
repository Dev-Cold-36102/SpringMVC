#include<iostream> 
        using namespace std; 
            
        int main(){

        int priceArr[5]={1,2,3};
        int count=1;
        int sum=0;
            for(int i=0, j=priceArr.length-1 ;i>0 ,j>0 ;i++ ,j--){     
                if(count<=3){
        sum+=priceArr[i]+priceArr[j];
        count++;
            }else
               break; 
        }
