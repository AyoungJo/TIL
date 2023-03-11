#include <stdio.h>
void main(){
	
	int jw, sw;
	int day;
	
	scanf("%d %d", &jw, &sw);
	scanf("%d", &day);
	
	for(int i=1; i<=day; i++){
		if(i%2!=0){
			if(jw%2==0){
				jw = jw/2;
				sw = sw+jw;
			}else{
				jw = jw/2;
				sw = sw + (jw+1);
			}			
		}
		else{
			if(sw%2==0){
				sw = sw/2;
				jw = jw+sw;
			}else{
				sw = sw/2;
				jw = jw + (sw+1);
			}	
		}
	}
		
	printf("%d %d", jw, sw);
}
