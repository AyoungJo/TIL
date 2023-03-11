#include <stdio.h>
void main(){
	
	int n, cnt = 0;
	int i,j;
	
	scanf("%d", &n);
	
	for(i=1; i<n; i++){
        j=i;
        while(j>0){
            if(j%10==3||j%10==6||j%10==9)    
				cnt++;
            j=j/10;
        }
    }
    printf("%d", cnt);	
}
