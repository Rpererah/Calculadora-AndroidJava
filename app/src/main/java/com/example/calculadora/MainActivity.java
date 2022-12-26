package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Inicializaçao das componentes do layout
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    TextView txtVisor;
    Button btnDivisao;
    Button btnMultiplicacao;
    Button btnSubtracao;
    Button btnAdicao;
    Button btnPonto;
    Button btnLimpar;
    Button btnIgual;
    //Inicialiazacao das variaveis a serem utilizadas
    boolean jaContemPonto;
    int contador = 0;
    //lista que armazenara valores
    String[] expressao;
    float Total = 0;
    String operador="operador";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instaciando as referencias dos botoes
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        expressao = new String[2];
        txtVisor = (TextView) findViewById(R.id.txtVisor);
        //para grandes das funcionalidades nossa variavel expressao nao pode ser nula por isso ja atribuimos um valor vazio para evitar erros
        expressao[contador]="";
        txtVisor.setText(expressao[contador]);
        btnDivisao = (Button) findViewById(R.id.btnDivisao);
        btnMultiplicacao = (Button) findViewById(R.id.btnMultiplicacao);
        btnSubtracao = (Button) findViewById(R.id.btnSubtracao);
        btnAdicao = (Button) findViewById(R.id.btnAdicao);
        btnPonto = (Button) findViewById(R.id.btnPonto);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnIgual = (Button) findViewById(R.id.btnIgual);

        //adicionei varios listeners que escutam seus respectivos botoes
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //essa verificacao e as demais evitam que o valor exceda o que foi pensado no layout
                if(!verificaLimiteDoVisor()){
                    return;
                }
                //essa adicao e as demais adicionam mais um elemento a variavel que possui um contador para referenciar se esse eh o primeiro operando ou o segundo
                expressao[contador]+="0";
                //esse os demais comandos exibem na tela o valor atual na variavel
                txtVisor.setText(expressao[contador]);
            }
        });

        //a explicacao aqui seria a mesma da anterior por isso verifique agora que os numeros adicionados sao os botoes referentes a eles
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="1";
                txtVisor.setText(expressao[contador]);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="2";
                txtVisor.setText(expressao[contador]);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="3";
                txtVisor.setText(expressao[contador]);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="4";
                txtVisor.setText(expressao[contador]);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="5";
                txtVisor.setText(expressao[contador]);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="6";
                txtVisor.setText(expressao[contador]);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="7";
                txtVisor.setText(expressao[contador]);
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="8";
                txtVisor.setText(expressao[contador]);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!verificaLimiteDoVisor()){
                    return;
                }
                expressao[contador]+="9";
                txtVisor.setText(expressao[contador]);
            }
        });
        //a funcao aqui do ponto requer uma verificacao
        btnPonto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vemos se ja existe um ponto no operando para evitar conflitos
                //se nao existir nos colocamos mas acionamos que apartir de agora existe
                if (jaContemPonto){
                    return;
                }
                expressao[contador]+=".";
                jaContemPonto=true;
            }
        });
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //funcao limpar realmente resata todas as operacoes alem de avisar que nao ha mais ponto
                expressao[0]="";
                expressao[1]="";
                contador=0;
                //assim como na expressao la em cima para diversas operacoes com a variavel operador ela nao poderia estar nula entao foi colocado um valor de referencia apenas
                operador="operador";
                jaContemPonto=false;
                txtVisor.setText(expressao[contador]);
            }
        });
        btnAdicao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //usamos equals pois operacoes com String nao permitem uma simples comparacao ja que elas sao referecias de um objeto
                if(operador.equals("operador")){
                    //atribuimos um novo valor ao operando e sera assim nos demais com sua respectiva operacao
                    operador ="soma";    //Soma
                    //adicionamos um andamento ao contador para avisar que agora vem o segundo operando
                    contador++;
                    //lembrando que por ser um novo operando apartir daqui temos que informar tambem que nao ha mais ponto que eh equivalente a nossa virgula
                    jaContemPonto=false;
                    expressao[contador]="";
                }
            }
        });

        btnSubtracao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operador.equals("operador")){
                    operador = "subtracao"; //subtrai
                    contador++;
                    jaContemPonto=false;
                    expressao[contador]="";
                }

            }
        });

        btnDivisao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operador.equals("operador")){
                    operador = "divisao";
                    contador++;
                    jaContemPonto=false;
                    expressao[contador]="";
                }
            }
        });
        btnMultiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operador.equals("operador")){
                    operador = "multiplicacao";
                    contador++;
                    jaContemPonto=false;
                    expressao[contador]="";
                }

            }
        });
        btnIgual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //colocamos essas verificacoes pois abaixo iremos transformar esses valores de String para float e elas nao podem nem ser nulas nem nao conter nada, entao atribuimos um valor 0 caso esteja vazia
                if(expressao[0]==""){
                    expressao[0]="0";
                }
                if(expressao[1]==""){
                    expressao[1]="0";
                }
                //aqui temos oum divisor de aguas que nao ocorre mas poderia ocorrer que eh o caso da divisao por 0 deveria resultar em erro ,como o float eh algo aproximado de zero e nao eh 0 propriamente entao essa funcao eh dispensavel
                //porem a deixei aqui ja pensando em um possivel problema
                if (divisaoPorZero())
                {
                        contador=0;
                        operador="operador";
                        jaContemPonto=false;
                        expressao[1]="0";
                        expressao[0]="0";
                        txtVisor.setText("Err");
                }else{
                    //aqui realmente temos a transformacao do valor que vem da funcao calcular que vem como float e para exibir trocamos novamente para string fora isso nada de novo temos que limpar os resultados para proximas operacoes
                    String ResultadoFinal=Float.toString(calcular());
                    txtVisor.setText(ResultadoFinal);
                    contador = 0;
                    expressao[0]="";
                    expressao[1]="";
                }



            }
        });

    }
    // aqui temos a funcao que converte nossas strings em floats para executar as operacoes matematicas
    private float calcular(){
        switch (operador){
            //Executa as operações e sai do switch
            case "soma": Total = (converteStringParaNumero(expressao[0]) + converteStringParaNumero(expressao[1])); break;
            case "subtracao": Total = (converteStringParaNumero(expressao[0]) - converteStringParaNumero(expressao[1])); break;
            case "multiplicacao": Total = (converteStringParaNumero(expressao[0]) * converteStringParaNumero(expressao[1])); break;
            case "divisao": Total = (converteStringParaNumero(expressao[0]) / converteStringParaNumero(expressao[1])); break;
        }
        //temos o retorno do valor que com diz a tipagem da funcao eh no formato float
        return Total;
    }

    //essa funcao atrela um limite a variavel pensando no estouro do layout pelos possiveis excessos o proprio elemento do layout possui um limite aqui apenas limitamos a variavel
    boolean verificaLimiteDoVisor(){
        if(expressao[contador].length()>7){
            return false;
        }
        return true;
    }
    //funcao apenas feita para encurtar a escrita em calcular()
    float converteStringParaNumero(String numero){
        float numeroConvertido=Float.parseFloat(numero);
        return  numeroConvertido;
    }
    //funcao que assegura a divisao por 0 nao estourar um erro do mesmo nome ErrorByDivideByZero
    boolean divisaoPorZero(){

        if(operador.equals("divisao") && Integer.parseInt(expressao[1])==0){
            return true;
        }
        return false;
    }
}


