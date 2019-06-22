                           
                           
                           
                           "--------------------------------------------------------"
                            "------                   HELP                      -----"
                            "------                                             -----"
                            "------            Instruções de Uso:               -----"
                            "------                                             -----"
                            "------  + Executar = java -jar executavel.jar      -----"
                            "------  + Cada Btn representa uma função*          -----"  
                            "------  + Datas/Horas são fantasiosas              -----"
                            "------  + Undo/Redo válidos para toda ação         -----"
                            "------  + Senha/user inicial - "admin/admin"       -----"
                            "------  + Dúvidas - mffsp@ic.ufal.br               -----"
                            "------                                             -----"
                            "------  *Obrigatório                               -----"
                            "--------------------------------------------------------"
      
      

OLDCOMMITS = https://github.com/mffdsp/P3/tree/master/Projeto-OO

## Funções implementadas

`Adição de um empregado -> OK`

`Remoção de um empregado -> OK`

<img src="srcIcon/tenor.gif" align= "right">

`Lançar um Cartão de Ponto -> OK`

`Lançar um Resultado Venda -> OK`

`Lançar uma taxa de serviço -> OK`

`Alterar detalhes de um empregado -> OK`

`Rodar a folha de pagamento para hoje -> OK`

`Undo/redo -> OK`

`Agenda de Pagamento -> OK`

`Criação de Novas Agendas de Pagamento -> OK`

# Instruções de entrada
 
```java
private static void addEmpregado(){

    insertName(String);
    insertAdress(String);
    insertType(int);
    insertMethod(int);
    insertSalary(double);
    insertBoolSindicaty(int);

}

private static void rmvEmpregado(){

    insertCode(String);

}

private static void launchCard(){

    insertCode(String);
    inserType(int);


}
private static void launchSellResult(){

    insertCode(String);
    insertValue(double);
    insertDay(int);
    
}
private static void launchSindicalTaxes(){

    insertSindicalCode(String);
    insertValue(double);
    
}
private static void editEmpregado(){

    insertCode(String);
    insertName(String);
    insertAdress(String);
    insertType(int);
    insertMethod(int);
    insertSalary(double);
    insertBoolSindicaty(int);

}
private static void payRoll(){

    confirmAction();

}
private static void UndoRedo(){

    confirmAction();
    
}
private static void searchEmpregado(){

    insertMode(int);
    insertSearch(String);
    insertRecover(String);

}

private static void createPayRoll(){

    insertName(String);
    insertType(int);
    insertDay(int);
    insertDayOfWeek(int);

}


```


.................

MIT License

Copyright (c) 2019 Mateus Felismino

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
