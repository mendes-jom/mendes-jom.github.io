import java.awt.*;
import java.io.*;
import java.lang.*;
import java.applet.*;
import java.applet.Applet;
import java.util.Enumeration;
import java.awt.Dialog;
import java.awt.Color;
import java.awt.Graphics;
//import netscape.javascript.*;

public class Irs99 extends java.applet.Applet {
  String   myString,zeString,PAYREC;
  int      IRS,DAC80,NOFIM,Zico,RL,DE,IRSPAGO,DRC55,ART55,COLECTAVEL,RB,MPS_PDR ;
  int[][]  XXX      =new int[20][25];
  int[]    ABAT1    =new int[25]; // XXX[1][]
  int[]    DRC      =new int[25]; // XXX[2][]
  int[]    RBA      =new int[6] ; // XXX[3][]
  int[]    RFA      =new int[6] ; // XXX[4][]
  int[]    DA       =new int[6] ; // XXX[5][]
  int[]    GRA      =new int[6] ; // XXX[6][]
  int[]    RBH      =new int[6] ; // XXX[7][]
  int[]    RFH      =new int[6] ; // XXX[8][]
  int[]    RLA      =new int[6] ; // XXX[11][]
  int[]    RLH      =new int[6] ; // XXX[12][]
  int[]   DEFTX     =new int[6] ; // XXX[13][];DEFTX

  int[]   DEFICIENTE=new int[6] ; // XXX[17][];DEFICIENTE
  int[]    DETI     =new int[6] ; // XXX[15][];DETI
  int PPR,PPH,OPC,PRI,BES,FIM,PPA,CON;
  int DAC99,DPPR,DPPH,DPRI,DBES,DPPA,DLimDiv,DEduca,DSeguro; // A Partir de 1999
  int Propinas=0;     // Só considerado em 1996
  int DiscEducDep=0;  // A partir de 1997
  int DiscEducDepNr=0;// A partir de 1997
  int Ano=3          ;// "1999"
  int ONtest ;      //   0: Old  1: New method
 // 	abstract void setBackground( Color.white );

  public void init() {
        zeString = new String("Zico Prog");
//	myString = new String("Zico: Cálculo de Irs... ");
        myString ="Zico: Cálculo de Irs... ";
        Zico=0;
	calcx();

  }
 
  public void paint (Graphics g) {

   this.setBackground( Color.white );
   Font f1=new Font("Courier",Font.PLAIN,12);
   g.setFont(f1);
   g.setColor(Color.blue);
   int mm=10;
   if (Zico==0)
 	  g.drawString(myString+Anos[Ano],mm,16);
      else 
	  g.drawString(zeString,mm,16);
   g.drawString("RB           "+myNR(RB),mm,10+15*2);
   g.drawString("DEsp.        "+myNR(DE),mm,10+15*3);
   g.drawString("RL           "+myNR(RL),mm,10+15*4);

	   g.drawString("ART55        "+myNR(ART55),mm,10+15*5);//70
	   g.drawString("DRC55        "+myNR(DRC55),mm,10+15*6);//85
	   g.drawString("COLECTAVEL   "+myNR(COLECTAVEL),mm,10+15*7);//100
	   g.drawString("IRS-COLECTA  "+myNR(IRS),mm,10+15*8);//115
	   g.drawString("IRS PAGO     "+myNR(IRSPAGO),mm,10+15*9);//130
	

   g.drawString("DAC99        "+myNR(DAC99),mm,10+15*10);//145
   g.drawString("DAC80        "+myNR(DAC80),mm,10+15*11);//160

   int nn=2;

   g.drawString(PAYREC,mm,163+15*nn);
   g.drawRoundRect(1,  1      ,220,171+15*nn ,7,7);
   g.drawRoundRect(3,  3      ,216, 20       ,7,7);
   g.drawRoundRect(3,150+15*nn,216, 20       ,7,7);
   g.drawRoundRect(3, 25      ,216,123+15*nn ,7,7);
   g.drawLine(    89, 25      , 89,147+15*nn     );
  }
//================================
  public String myNR(int i){
    	String s=""+i;
        String ss="";
        String s1="";
        i=s.length();
        if (i <=12) { 
		while (s.length()<12){s=" "+s;}
		int j;for ( j=0 ;j<9 ; j=j+3)    {
                     s1=s.substring(j,j+3);
                     if (s1.equals("   ") || s1.equals("  -")) 
			s1=" "+s1; else  s1=s1+",";
		        ss=ss+s1;
                                }
		ss=ss+s.substring(j,j+3);               
                    }
     return ss;
  }
//================================
  public int DizPropinas (int n) { 
    Propinas=n;
//    repaint();
    return Propinas;
  }
//================================
  public void DiscEduc(int a,int b){
    DiscEducDep=a;
    DiscEducDepNr=b;  
}
//================================
  public void SayString (String aString) { 
    myString=aString;
    Zico=0;
    repaint();
  }
//-----------------------------------
  public int IndexYear(String Ano) {
  int x ;
  int y=Anos.length;
  for ( x=y-1 ; x==0 ; x=x-1)      
      {if (Anos[x] == Ano)  break;}
  return x;
  }
//-----------------------------------
  public void sayZico(int n) {
  zeString = "Programas Zico...";
  Zico=n;
       repaint();
  }
//================================
public void getArr(int a,int b,String c) {
    CalcIr(a, b,c) ;
    String b0=">" ;
       int j;for ( j=1 ;j<=b ; j=j+1)    {b0=b0+XXX[a][j]+"=";}
}
//---------------------------------------------
  public void CalcIr(int m,int n,String b) {
  int j;
  int x1=     b.indexOf(",");
  int x2;
  String b2=" "+x1+"-"+b.substring(0,x1)+":";
  XXX[m][0]=Integer.parseInt(b.substring(0,x1));
  for ( j=1 ;j<n ; j=j+1)    {
      x2=b.indexOf(",",x1+1);
      XXX[m][j]=Integer.parseInt(b.substring(x1+1,x2));
      x1=x2;
      }
  XXX[m][j]=Integer.parseInt(b.substring(x1+1,b.length()));
}
//---------------------------------------------
public void CalcIrs(int n,int a, int b,int c,int nf,int na) {
//  public void CalcIrs(int n,int a, String b,String c,int nf,int na) {
// CalcIrs(0,eval(top.MPS_PDR),
//             top.ID[3],  ///top.ANOS[top.ID[3]],
//             top.ID[1],  ///top.CIVIL[top.ID[1]],
//             top.ID[2],top.ID[7]) 
// n = (0,1)   para sair mensagem especial .... > testar
// a = 	       ; MPS_PDR
// b = (0,1,2  : "1996",....
// c = 0..>5   : "C",....,"F"
// nf =        : Número de filhos
// na =        : número de ascendentes..

        Zico=n;
        ONtest=n ;      //   "O": Old  "N" New method

        if (ONtest==1) {zeString ="@ José  Mendes - novo 99 @";}
// Mais vale ter um \n ProgramaZico \nque não ter \nprograma nenhum...";
        int Divisor=100;
        Ano=b; //IndexYear(b)-1;
        int LimDiv,Educa,Seguro,Donat,Const,Quot;
        int Div,Renova;
  MPS_PDR=a;
  RL=-MPS_PDR;RB=0;RL=0;DE=0;
  int CX=0;if (c>0) {CX=1;}
	if (CX==0 ){     // c.equals("C")
		LimDiv=LimDiv2[Ano];Educa =Educa2[Ano];Seguro=Seguro2[Ano];
		Donat =Donat2[Ano];Const =Const2[Ano];Quot =2;
             	Divisor=Divisor2[Ano]; 
                PPR  =PPR2[Ano];PPH  =PPH2[Ano];OPC  =OPC2[Ano];
		PRI  =PRI2[Ano];BES  =BES2[Ano];FIM  =FIM2[Ano];
                PPA  =PPA2[Ano];CON  =CON2[Ano];
		DAC80=DAC80_2[Ano];
		Renova=Renova2[Ano]; 
	// A partir de 1999:
                DPPR  =DPPR2[Ano];DPPH =DPPH2[Ano];
		DPRI  =DPRI2[Ano];DBES =DBES2[Ano];DPPA  =DPPA2[Ano];
		DLimDiv=DLimDiv2[Ano];DEduca =DEduca2[Ano];DSeguro=DSeguro2[Ano];
       
            } 
        else{
		LimDiv=LimDiv1[Ano];Educa =Educa1[Ano];Seguro=Seguro1[Ano];
		Donat =Donat1[Ano];Const =Const1[Ano];Quot =2;
             	Divisor=Divisor1[Ano];
                PPR  =PPR1[Ano];PPH =PPH1[Ano];OPC =OPC1[Ano];
		PRI  =PRI1[Ano];BES =BES1[Ano];FIM =FIM1[Ano];
		PPA  =PPA1[Ano];CON =CON1[Ano];  
		DAC80=DAC80_1[Ano];
		Renova=Renova1[Ano];  
	// A partir de 1999:

                DPPR  =DPPR1[Ano];DPPH =DPPH1[Ano];
		DPRI  =DPRI1[Ano];DBES =DBES1[Ano];DPPA  =DPPA1[Ano];
		DLimDiv=DLimDiv1[Ano];DEduca =DEduca1[Ano];DSeguro=DSeguro1[Ano];
            }
  

// ** ART55: a) -> j)
IRSPAGO=0;
int Div2=0,zQuots=0;
int[] BaseQuots=new int[6] ;;
       int j;for ( j=1 ;j<=21 ; j=j+1)    {ABAT1[j]=XXX[1][j];
					     DRC[j]=XXX[2][j];}
             for ( j=1 ;j<=5  ; j=j+1)    {RBA[j]=XXX[3][j]; 
                			   RBH[j]=XXX[7][j];
 // nao necessário:           			   RLA[j]=XXX[11][j];
                			   RLH[j]=XXX[12][j];
					   DEFTX[j]=XXX[13][j];
                DEFICIENTE[j]  =XXX[17][j]; // new 99
		DETI[j] =  XXX[15][j];      // NEW 99:DETI
                DA[j]   =  XXX[ 5][j];      // NEW 99:DA
if ((ONtest==0) && (XXX[ 5][j]>0) )  
       {DA[j]   =  XXX[ 5][j]/XXX[ 5][j]*510000;}//simplificacão 99
                DE     =DE     + DA[j]+DETI[j];//99:DA+DETI
		RL     =RL     +RBA[j]+XXX[6][j]+RLH[j]-XXX[5][j] //+RBA[j]+RBH[j]+XXX[6][j]-XXX[5][j]
                                             +XXX[14][j]-XXX[15][j];//99:+TRTI-DETI
	//	RB     =RB     +RBA[j]+RBH[j]+XXX[14][j];//99:+TRTI
                RB     =RB     +RBA[j]+XXX[6][j]+RBH[j]+XXX[14][j];//99:+TRTI
                IRSPAGO=IRSPAGO+XXX[4][j]+XXX[8][j]+XXX[16][j];//99:+RFTI          
                BaseQuots[j]=RBA[j]+XXX[6][j];
                Div2=Div2+RBA[j];
                if (Ano>1) { Div2=Div2+RBH[j] ; BaseQuots[j]=BaseQuots[j]+RBH[j];}
                                           }


DRC55=0;
ART55=0;

int Renova97=0;

           DRC55=DRC55+Math.min(OPC,DRC[7]+DRC[8]); // O que é ??

           DRC55=DRC55+Math.min(FIM,DRC[13]+DRC[14]); // O que É??
 
           DRC55=DRC55+Math.min(CON,DRC[17]+DRC[18]);

if (ONtest==0) {
	   DRC55=Math.min(PPR,Math.min(RB*PPRx[Ano]/100,DRC[1]+DRC[2])); // 20% RB
	   DRC55=DRC55+Math.min(PPH,DRC[3]+DRC[4]+DRC[5]+DRC[6]);
           DRC55=DRC55+Math.min(PRI,(PRIx[Ano]*(DRC[9] +DRC[10])+50)/100);
           DRC55=DRC55+Math.min(BES,(BESx[Ano]*(DRC[11]+DRC[12])+50)/100);
           DRC55=DRC55+Math.min(PPA,PPAx[Ano]*(DRC[15]/100+DRC[16]));
 

           ART55=(ABAT1[1] // 55-a)Desp de saude do agreg familiar
                +ABAT1[2] // 55- )Desp de saude dos ascendentes def
                +ABAT1[3] // 55- )Desp com educ e reab defic
                +ABAT1[4] // 55- )Prémios saúde defic
                +ABAT1[5] // 55-g)Pensões 
                +ABAT1[6] // 55-h)Indemnizações pagas resc c.t.
                );
	   int div,z8,z8p,z8r=0,z8d;
           if (Ano==0){ // (1996.... ABAT1[9] não é usado
                  z8 =Math.min(LimDiv       ,ABAT1[7 ]         // 55-b)Desp saude asc não def
					    +ABAT1[8 ]         // 55-c)Desp c/Educação
					    +ABAT1[10] )   ;   // 55-d)lares
                  z8p=Math.min(LimDiv+Educa ,z8+Propinas )-z8; // 55-c-só Propinas
                  z8r=Math.min(LimDiv+Renova,z8+ABAT1[12])-z8; // 55-i)Energias renováveis
	          ART55=ART55+z8+z8p+z8r;
                  ART55=ART55+Math.min(ABAT1[13],
                                   Quot*Div2*1/100  ); // 55-j) Quotizações sindicais
		     }			
              else   {
                  for ( j=1 ;j<=5  ; j=j+1){
                  ART55=ART55+Math.min(XXX[9][j],
                                   Quot*BaseQuots[j]*1/100  ); // 55-j) Quotizações sindicais
					   }  
                if (Ano==1){ // 1997 só?... // 60000/30000 :: em 1998 passa para DAC80
                  z8r=Math.min(Renova       ,ABAT1[12]   )   ;}//55-i)Energias renováveis
                z8 =Math.min(LimDiv        ,z8r
		            		    +ABAT1[7]          // 55-b)Desp saude asc não def
					    +ABAT1[10] )   ;   // 55-d)lares
//  int DiscEducDep=0;  // A partir de 1997
//  int DiscEducDepNr=0;// A partir de 1997
//  REVER:::: 3ºFilho+++ e se Pensao?? // 55-c) dependentes
                if (DiscEducDepNr>2){Educa=Educa+(DiscEducDepNr)*EducaN[Ano] ;} 
		  	
		z8p=Math.min(LimDiv+Educa ,z8+ABAT1[8]         // 55-c)Desp c/Educação -Sj Pass A
//                                             +ABAT1[9]         // 55-c)Desp c/Educação -Sj pass B
					     +DiscEducDep      // 55-c) dependentes
			      )-z8;    
	        ART55=ART55+z8+z8p;		     
                     }

	   ART55=ART55+Math.min(Seguro,ABAT1[11]);
	   ART55=ART55+Math.min(LimJuros[Ano] ,ABAT1[14]);     // 55-e)Juros
               }
// Continua em 1999 ???:

           ART55=ART55+Math.min(Const,ABAT1[15]*Constx[Ano]);  // Construção
	   ART55=ART55+(ABAT1[16]*110+50)/100 ; // Donativos
           ART55=ART55+Math.min(Donat*RL,(ABAT1[17]*110+50)/100 ); // Donativos



// ** IRS
//        COLECTAVEL=a;
        int RT=0;//RETENÇÔES ?????
COLECTAVEL=Math.max(0,RL-RT-ART55-DRC55);
///////////////////////////////////////////////// : 1999
  if  (ONtest==1)  { COLECTAVEL=RL-RT;}
/////////////////////////////////////////////////
        a=COLECTAVEL*100/Divisor;
        IRS=0;
   	if (  a <= M1[Ano] ) {  IRS=(  a             *T1[Ano]+99)/100 + P1[Ano];}
    	if ( (a  > M1[Ano] ) && (a <= M2[Ano] ) ) { 
           			IRS=(( a - M1[Ano] ) *T2[Ano]+99)/100 + P2[Ano];}
    	if ( (a  > M2[Ano] ) && (a <= M3[Ano] ) ) { 
           			IRS=(( a - M2[Ano] ) *T3[Ano]+99)/100 + P3[Ano];}
    	if (  a  > M3[Ano] ) {  IRS=(( a - M3[Ano] ) *T4[Ano]+99)/100 + P4[Ano];}

if (  Ano  >= 3 ) {
        if (  a  > M4[Ano] ) {  IRS=(( a - M4[Ano] ) *T5[Ano]+99)/100 + P5[Ano];}
                     ;}

// 	if ( c.equals("C") ) { IRS=IRS* 2 ;}
	if (CX==0 ){ IRS=IRS* 2 ;}     // c.equals("C")

// ** DAC80
//        DAC80    =34500 ;
//        if ( c.equals("C") )  {DAC80 = 26300*2  ; }                
  	int cada=0;
        if (nf>=1) {cada=     DAC80_F1[Ano];}
  	if (nf==2) {cada=cada+DAC80_F2[Ano];}
  	if (nf==3) {cada=cada+DAC80_F3[Ano];}
//  	if (nf>=4) {cada=cada+DAC80_FX[Ano]*(nf-3);}
	if (nf>=4) {cada=cada+DAC80_FX[Ano];}
	DAC80=DAC80+nf*cada+DAC80_AX[Ano]*na;
/*        
        DAC80=DAC80+nf*DAC80_F1[Ano]+na*DAC80_AX[Ano];

  	if (nf==2) {DAC80=DAC80+DAC80_F2[Ano];}
  	if (nf==3) {DAC80=DAC80+DAC80_F3[Ano];}
  	if (nf>=4) {DAC80=DAC80+DAC80_FX[Ano]*(nf-3);}
*/

//COMPUTADORES:(1998-2001)
	DAC80=DAC80+Math.min(ABAT1[18] *COMPx[Ano]/100,COMP[Ano]);

//ACONSELHAMENTO JURÍDICO:(1998..)
	DAC80=DAC80+Math.min(ABAT1[19] *JURIx[Ano]/100,JURI[Ano]);

//energias renováveis:   :(1998,...) ver acima Renova1 Renova2 Renovax

       if (Ano >=2){ // (1998....
	DAC80=DAC80+Math.min(ABAT1[12] *Renovax[Ano],Renova);
                   }
//DAC80=ABAT1[12];
///////////////////////////////////////////////// : 1999

  if  ( ONtest==1) {      //   "O": Old  "N" New method
//        DAC99=DAC99+Math.min(DPPR,Math.min(RB*DPPRx[Ano]/100,DRC[1]+DRC[2]));
	DAC99=DAC99+Math.min(DPPR,(DPPRx[Ano]*(DRC[1]+DRC[2]              )+50)/100);
	DAC99=DAC99+Math.min(DPPH,(DPPHx[Ano]*(DRC[3]+DRC[4]+DRC[5]+DRC[6])+50)/100);
        DAC99=DAC99+Math.min(DPRI,(DPRIx[Ano]*(DRC[9] +DRC[10]            )+500)/1000);
        DAC99=DAC99+Math.min(DBES,(DBESx[Ano]*(DRC[11]+DRC[12]            )+500)/1000);
        DAC99=DAC99+Math.min(DPPA,(DPPAx[Ano]*(DRC[15]+DRC[16]            )+500)/1000);
        DAC99=DAC99+Math.min(CON,1*(DRC[17]+DRC[18]));
       // 20% RB
 

	int div=0,z8=0,z8p=0,z8r=0,z8d=0;
 //       DAC99=DAC99+1000000;

        DAC99=DAC99+(ABAT1[1] // 55-a)Desp de saude do agreg familiar
                +ABAT1[2] // 55- )Desp de saude dos ascendentes def
                +ABAT1[3] // 55- )Desp com educ e reab defic
                +ABAT1[4] // 55- )Prémios saúde defic
                +ABAT1[5] // 55-g)Pensões 
                +ABAT1[6] // 55-h)Indemnizações pagas resc c.t.
                )*DSaudex[Ano]/100;


           for ( j=1 ;j<=5  ; j=j+1){
                ART55=ART55+Math.min(XXX[9][j],
                                   Quot*BaseQuots[j]*1/100  ); // 55-j) Quotizações sindicais
				    }

                z8 =Math.min(DLimDiv       , ABAT1[7]          // 55-b)Desp saude asc não def
					    +ABAT1[10] )   ;   // 55-d)lares

//  REVER:::: 3ºFilho+++ e se Pensao?? // 55-c) dependentes
                if (DiscEducDepNr>2){DEduca=DEduca+(DiscEducDepNr)*DEducaN[Ano] ;} 
		  	
//		z8p=Math.min(DLimDiv+DEduca , ABAT1[8]         // 55-c)Desp c/Educação -Sj Pass A
//					     +DiscEducDep      // 55-c) dependentes
//			      )-z8;    
//	        DAC99=DAC99+z8+z8p;
			// 1999 Falta corrigir Com pensões Lares certos casos        
	DAC99=DAC99+Math.min(DEduca ,(DEducax[Ano]   *(ABAT1[9]+ABAT1[8]        )+50)/100);            

	DAC99=DAC99+Math.min(DSeguro,(DSegurox[Ano]  *(ABAT1[11]                )+50)/100);
	DAC99=DAC99+Math.min(DLimJuros[Ano]
                                    ,(DLimJurosx[Ano]*(ABAT1[14]                )+50)/100);     // 55-e)Juros

//DAC99=DSeguro;
//        DAC99=ABAT1[9];//DEducax[Ano] ;// DEduca ;//(DEducax[Ano])   *(ABAT1[8]                 )+50)/100;
                   }
/////////////////////////////////////////////////

	
	
        NOFIM=Math.max(0,IRS-DAC80-DAC99);

        NOFIM=NOFIM-IRSPAGO;
   	if ( NOFIM ==0 ) {PAYREC="CONTAS BEM Feitas...";}
   	if ( NOFIM > 0 ) {PAYREC=" A PAGAR : "   +   myNR(+NOFIM) ;} 
   	if ( NOFIM < 0 ) {PAYREC=" A RECEBER : " +   myNR(-NOFIM) ;}
//	myString ="zico";
      repaint();
  }
  public String PAYREC()   {  return PAYREC;  }
  public int    sayIRS()   {  return IRS   ;  }
  public int    sayDAC80() {  return DAC80 ;  }
  public int    sayIRSPAGO() {  return IRSPAGO ;  }
  public int    sayDRC(int x) {  return DRC[x] ;  }


//-----------------
  public int[] sayRESP() {
//        RESP[0]=FIM;RESP[1]=DAC80;RESP[2]=IRSPAGO;RESP[3]=IRS;
  int [] ss={1,2,3};
  return ss;//RESP[];
  }

///////////////////////////////////////////////////////////////////////
public String[] Anos    ={ "1996" , "1997" ,"1998" ,"1999"};
public int[]    Divisor1={   100  ,    100 ,  100 ,100};// 95%=0.95
public int[]    Divisor2={   195  ,    200 ,  200 ,200};//195%=1.95

public int[]    M0      ={0       ,      0 ,    0  ,0 };
public int[]    M1      ={1010000 ,1050000 ,1080000 , 700000};
public int[]    M2      ={2350000 ,2435000 ,2500000 ,1105000};
public int[]    M3      ={6000000 ,6150000 ,6280000 ,2750000}; //2560000};
public int[]    M4      ={999999999,999999999,999999999,6405000};   // New 1999
public int[]    T1      ={15      ,     15 ,     15 ,14};// %
public int[]    T2      ={25      ,     25 ,     25 ,15};// %
public int[]    T3      ={35      ,     35 ,     35 ,25};// % 
public int[]    T4      ={40      ,     40 ,     40 ,35};// %
public int[]    T5      ={40      ,     40 ,     40 ,40};// %    // New 1999

public int[]    P1=new int[Anos.length];
public int[]    P2=new int[Anos.length];
public int[]    P3=new int[Anos.length];
public int[]    P4=new int[Anos.length];
public int[]    P5=new int[Anos.length];   // New 1999 
//ART55 < ABAT1[]
//-- Saúde ascend,Lares... + Desp Educação 
public int[]    LimDiv1 ={159000  , 163000 , 166000 ,169320};
public int[]    LimDiv2 ={319000  , 327000 , 332000 ,338640};



// 1998:SE Acima inclui Desp com Ed sem Pensão
//         ou se a  Pensão não cubra as despesas
public int[]    Educa1  ={183000-LimDiv1[0], 375000-LimDiv1[1]
				           , 385000-LimDiv1[2]
				           , 392700-LimDiv1[3]};// New 1999
public int[]    Educa2  ={365000-LimDiv2[0], 375000-LimDiv2[1]
				           , 385000-LimDiv2[2]
				           , 392700-LimDiv2[3]};// New 1999
public int[]    EducaN  ={                0, 20000  //(1997.. a mais pelo 3º,4º,.. filho
				           , 35000 , 35700};
//--Energia renovável:
public int[]    Renova1 ={262000-LimDiv1[0],30000  ,10000 ,10000};
public int[]    Renova2 ={422000-LimDiv1[0],60000  ,10000 ,10000};
public int[]    Renovax ={100              ,100    ,20   ,20};// %
//-- Prémios seg de vida: (Sim: 1998= 1997)
public int[]    Seguro1 ={35000   , 36000  ,  36000 ,36000};
public int[]    Seguro2 ={70000   , 72000  ,  72000 ,72000};



//--Donativos (1998 parece ter mudado --- Verificar se 110% e se igual para ambos)
public int[]    Donat1  ={15      ,     15 ,     15  ,15};// 0.15:15%
public int[]    Donat2  ={30      ,     30 ,     15 , 15};// 0.30:30%
public int[]    Donatx  ={110     ,    110 ,    110 ,110};// 1.1 :110%
//Aquisição ou construção sem crédito..
public int[]    Const1  ={297000  , 305000 , 305000 ,305000};
public int[]    Const2  ={297000  , 305000 , 305000 ,305000};
public int[]    Constx  ={10      ,     10 ,     10  ,10};// 0.1 : 10%
// RENDAS
public int[]    Rendas  ={0       , 500000 , 500000 , 500000};// Novo 1997

//
//public int[]    Quot1   ={0       ,      2 ,      2 }; //??
//public int[]    Quot2   ={0       ,      2 ,      2 };
//
//-- Juros e Amort de dívidas...
public int[]    LimJuros ={297000  , 305000 , 308000 ,314160};


// Quotizações sindicais, acrescidas de 50%
public int[]    QuotAx   ={1       ,      1 ,      1 ,1};// 0.01:  1%
public int[]    QuotHx   ={0       ,      1 ,      1 ,1};// 0.01:  1%


/////////==============================================DRC55 < DRC[]

public int[]    PPR1    ={400000  , 410000 , 418000 ,426360};
public int[]    PPR2    ={800000  , 820000 , 836000 ,852720};
public int[]    PPRx    ={    20  ,     20 ,     20 ,20};//0.2 : 20%

public int[]    PPH1    ={400000  , 410000 , 418000 ,420000};
public int[]    PPH2    ={400000  , 410000 , 418000 ,420000};
public int[]    PPHx    ={     0  ,      0 , 0      ,25};//0.25 : 25% das entregas


public int[]    OPC1    ={0       ,      0 ,      0 ,0}; ///??
public int[]    OPC2    ={0       ,      0 ,      0 ,0}; ///??
// Privatizações:
public int[]    PRI1    ={130000  , 130000 , 130000 ,132600};
public int[]    PRI2    ={261000  , 261000 , 261000 ,266220};
public int[]    PRIx    ={    20  ,     20 ,     20 ,20};//0.2 : 20%

public int[]    BES1    ={196000  , 196000 , 196000 ,199920};
public int[]    BES2    ={391000  , 391000 , 391000 ,398820};
public int[]    BESx    ={0       ,     30 ,     30 ,30};//0.3 : 30%


public int[]   DPRI1    ={0  , 0 , 0 ,32500};// Max Start 1999
public int[]   DPRI2    ={0  , 0 , 0 ,65000};// Max Start 1999
public int[]   DPRIx    ={0  , 0 , 0 , 50};//0.05 %

public int[]   DBES1    ={0  , 0 , 0 ,49000};// Max Start 1999
public int[]   DBES2    ={0  , 0 , 0 ,98000};// Max Start 1999
public int[]   DBESx    ={0  , 0 , 0 , 75};//0.075 : 75 %o per mil



public int[]   DPPA1    ={0  , 0 , 0 ,37500};// Max Start 1999
public int[]   DPPA2    ={0  , 0 , 0 ,75000};// Max Start 1999
public int[]   DPPAx    ={0  , 0 , 0 , 75};//0.075 : 75 %o per mil

public int[]   DPPR1    ={0 , 0 , 0 ,107000};// Max Start 1999
public int[]   DPPR2    ={0 , 0 , 0 ,214000};// Max Start 1999
public int[]   DPPRx    ={0 , 0 , 0 ,    25};//0.25 : 25% do RB

public int[]   DPPH1    ={0  , 0 , 0 ,105000};// Max Start 1999
public int[]   DPPH2    ={0  , 0 , 0 ,105000};// Max Start 1999
public int[]   DPPHx    ={0  , 0 , 0 ,25    };//0.25 :25% das entregas


public int[]    FIM1    ={0       ,      0 ,      0 ,0};//Só 1992 e 1994...
public int[]    FIM2    ={0       ,      0 ,      0 ,0};//Só 1992 e 1994...

public int[]    PPA1    ={150000  , 150000 , 150000 ,150000};
public int[]    PPA2    ={300000  , 300000 , 300000 ,300000};
public int[]    PPAx    ={    30  ,     30 ,     30 ,30};//0.3 : 30%
// Conta Poupança Condomínio : 1 % do valor matricial com limite de: (1998=1997)
public int[]    CON1    ={ 26000  ,  27000 ,  27000 ,10000};
public int[]    CON2    ={ 26000  ,  27000 ,  27000 ,10000};
// DEDUÇÕES À COLECTA:(ARTº.80.º A DO CIRS)
// PESSOAS E FAMILIARES:
public int[]    DAC80_1 ={33000    ,34500    ,  35200  ,36000};
public int[]    DAC80_2 ={25000*2  ,26300*2  ,  26800*2,27400*2};
public int[]    DAC80_AX={    0    ,19000    ,  19400  ,19800};
public int[]    DAC80_F1={ 18000   ,19000    ,  19400  ,19800};
public int[]    DAC80_F2={  +200   ,     +210,   +220  , +225};
public int[]    DAC80_F3={  +400   ,     +430,   +440  ,+450};
public int[]    DAC80_FX={  +500   ,     +550,   +560  ,+575};
//COMPUTADORES:(1998-2001):art 49-D do EBF
public int[]    COMP    ={ 0  , 0 , 30000 ,30000};//*=
public int[]    COMPx   ={ 0  , 0 ,    20 ,20};//%*=
//ACONSELHAMENTO JURÍDICO:(1998..)
public int[]    JURI    ={ 0  , 0 , 20000 ,25000};//*+
public int[]    JURIx   ={ 0  , 0 ,    20 ,20};//%*=
//energias renováveis:   :(1998,...) ver acima Renova1 Renova2 Renovax

///////////////////////////////////// 1999 ///////////////////
public int[]   DSaudex   ={0  , 0 , 0 ,30};// 1999*

public int[]   DLimDiv1  ={0  , 0 , 0 ,56400};// 1999
public int[]   DLimDiv2  ={0  , 0 , 0 ,56400};// 1999

public int[]   DLimDivM  ={0  , 0 , 0 ,28200};// 1999 se Lares+Educ=
public int[]   DLimDivx  ={0  , 0 , 0 ,25};// 1999=

public int[]   DEducax   ={0  , 0 , 0 ,30};// 1999*
public int[]   DEduca1   ={0  , 0 , 0 ,101500};// 1999
public int[]   DEduca2   ={0  , 0 , 0 ,101500};// 1999
public int[]   DEducaN   ={0  , 0 , 0 ,10000};// 1999 a mais pelo 3º,4º,.. filho

public int[]   DSeguro1  ={0   , 0  ,  0 ,10000}; // 1999*=
public int[]   DSeguro2  ={0   , 0  ,  0 ,20000}; // 1999*=
public int[]   DSegurox  ={0   , 0  ,  0 ,25 }; // 1999 : 25 %=*

public int[]   DLimJuros ={0  , 0 , 0 ,94300};//1999*
public int[]   DLimJurosx={0  , 0 , 0 ,30};//1999*

//
	
///////////////////////////////////////////////////////////////////////
  public int calcx() {
  int x ;
  for ( x=0 ; x<Anos.length ; x=x+1)      
      {P1[x]=0;
       P2[x]=P1[x]+(M1[x]-M0[x])*T1[x]/100 ;
       P3[x]=P2[x]+(M2[x]-M1[x])*T2[x]/100 ;
       P4[x]=P3[x]+(M3[x]-M2[x])*T3[x]/100 ;
       P5[x]=P4[x]+(M4[x]-M3[x])*T4[x]/100 ;}
  return x;
  }


//-----------------------------------

}
