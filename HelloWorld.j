.class public HelloWorld
.super java/lang/Object

.field static scanner Ljava/util/Scanner;

;
; standard initializer
.method public <init>()V
   aload_0
   invokenonvirtual java/lang/Object/<init>()V
   return
.end method

; Funzione che legge un intero da standard input
.method public static readInt()I
    .limit locals 0
    .limit stack 2
    
    getstatic HelloWorld/scanner Ljava/util/Scanner;
    invokevirtual java/util/Scanner/nextInt()I
    ireturn 

.end method

; Funzione che scrive un intero da standard input
.method public static writeInt(I)V
    .limit locals 1
    .limit stack 3
    
    getstatic java/lang/System/out Ljava/io/PrintStream;
    iload 0
    invokevirtual java/io/PrintStream/println(I)V
    return
    
.end method

.method public static main([Ljava/lang/String;)V
    .limit locals 5
    .limit stack 3
    
    ; Inizializzo lo scanner ( serve alla funzione readInt)
    new java/util/Scanner
    astore 1
    aload 1
    getstatic java/lang/System/in Ljava/io/InputStream;
    invokespecial java/util/Scanner/<init>(Ljava/io/InputStream;)V
    aload 1
    putstatic HelloWorld/scanner Ljava/util/Scanner;
    ; Fine inizializzazione scanner
    
    invokestatic HelloWorld/readInt()I
    istore 3
    
    iload 3
    ldc 5
    iadd
    istore 3
    
    iload 3
    invokestatic HelloWorld/writeInt(I)V
    return
    
.end method