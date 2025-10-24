public class Matriz {
    \\Declaración de variable 
        int cont =0 ; 
   String palabra = "SATOR"; 
       String [][] matriz={
    {"S","A","T","O","R"},
    {"A","R","E","P","O"},
    {"T","E","N","E","T"},
    {"O","P","E","R","A"},
    {"R","O","T","A","S"}, };
        \\Recorrido horizontal 
      for( int i=o ; i<5 ; i++){
   boolean encontrada = true; 
for( int j=0  ;  j<5  ; j++){
 if ( matriz [i][j] .chartAt(0) !=palabra . chartAt(j){
        encontrada=false;
       break;
 }
} 
     if ( encontrada ) {
             contador++;

  }
}
  
        \\ Recorrido vertical 
  for( int j=0 ; j <5 ; j++){
   boolean encontrada=true ; 
       for ( int i=0 ; i <5 ; i ++){
  if ( matriz [i][j] . chartAt (0) != palabra.chartAt (i){
            encontrada = false ; 
           break; 
   }
}
    System.out.println("La palabra se repite"+" "+cont+" "+"veces ");
   }
}


