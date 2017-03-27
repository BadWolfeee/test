package kalki;

public class Operacje {

int a=0;
char b[];
char c;
char sum; 
int i=0;

while(1){


if(bit_is_clear(PINB,4)){
a=1;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,5)){
a=2;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,6)){
a=3;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,7)){
c="+";
i++;
lcd_puts(c);
}



if(bit_is_clear(PINB,4)){
a=4;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,5)){
a=5;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,6)){
a=6;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,7)){
c="-";
i++;
lcd_puts(c);
}


if(bit_is_clear(PINB,4)){
a=7;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,5)){
a=8;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,6)){
a=9;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,7)){
c="*";
i++;
lcd_puts(c);
}

if(bit_is_clear(PINB,4)){
c="C";
i++;
lcd_puts(c);
LCD_CLEAR;
i=0;
}

if(bit_is_clear(PINB,5)){
a=0;
itoa(a,b,10);
i++;
lcd_puts(b);
}

if(bit_is_clear(PINB,6)){
c="=";
i++;
lcd_puts(c);
}

if(bit_is_clear(PINB,7)){
c="/";
i++;
lcd_puts(c);
}
}}

}
