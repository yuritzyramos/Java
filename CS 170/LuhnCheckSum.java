public class LuhnCheckSum{
	public static void main (String[] args){
luhnChecksum(new int[]{4,5,6,3,9,2}); //output 30
luhnChecksum(new int[]{4,9,9,1,6,5,7}); //output 40
luhnChecksum(new int[]{5,4,1,2,7,5,3,4,5,6,7,8}); //output 49
luhnChecksum(new int[]{5,5,2,9,4,2,0,3,5,0,6,1,5,4,6,5});//output 50
luhnChecksum(new int[]{3,1,4,1,5,9,2,6,5,3,5,8,9,7,9,3});//output 77
	}
//This method returns the checksum of an array of integers
public static int luhnChecksum(int[] x){
	int i = 0;
	int checksum = 0; 
while(i < x.length){
//intitialize in while loop so product resets after every iteration 
int product = 0;
//if the index of an element is even multiply the element by 2
 if( i % 2 == 0){
	product = x[i] * 2;
}
//if the above statement isn't true multipy the element by 1
else {
	product = x[i] * 1;
}
//if the integer is greater than or equal to 10
if(product >= 10){
	int num = 0; 
//This takes the remainder of a two digit number divided by 10 
// 1 (the first digit) is then added to it 
//This vaule is then added to the checksum 
	for(int k = 0; k < 1; k++){
  	num = product % 10; //assigns remainder to varaible nums 
  	checksum = checksum + num + 1;//checksum plus the sum of the remainder and 1
 }
}
//if the integer is not greater than or equal to ten
//add it to the sum
else{
	checksum = checksum + product;
}
i++;
	}
System.out.println(checksum);
return checksum;	
 }
}