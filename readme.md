# Instruções para Executar um Projeto Java via Terminal no Ubuntu

Estas são as instruções para executar um projeto Java que já contém os arquivos JAR no Ubuntu via terminal.

## Pré-requisitos

Certifique-se de ter o Java Runtime Environment (JRE) instalado no seu sistema. Se ainda não tiver, você pode instalá-lo com o seguinte comando:

```bash
sudo apt update
sudo apt install default-jre
```

## Executando o Projeto

1. Clone o Repositório:

```bash
git clone https://github.com/pablodeyvid11/ABB
cd ABB
```

2. Executar o Arquivo JAR ABBVisão:

Para o JAR ABBVisão, execute-o da seguinte maneira:

```bash
java -jar ABBVisao.jar
```

3. Executar o Arquivo JAR ABBArquivo:

Para o JAR ABBArquivo, execute-o com os parâmetros "entrada.txt" e "comandos.txt" da seguinte maneira:

```bash
java -jar ABBArquivo.jar entrada.txt comandos.txt
```
Certifique-se de ajustar os nomes dos arquivos conforme necessário.

4. Observações Adicionais:
- Certifique-se de que todas as dependências necessárias estão satisfeitas.
- Se o projeto utilizar algum serviço externo, verifique se a conexão com a internet está ativa.
- Leia a documentação do projeto para obter informações adicionais sobre a configuração e execução.
