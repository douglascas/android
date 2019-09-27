# android


Utilizem a develop para atualização do projeto.

# Utilização do repositório 
A instancia do repositório deve ser obtida pelo:

    I{Entidade}Repository er = {Entidade}RepositoryFactory.getInstance().getRepository();
Exemplo de uso:

    IDogRepository dogRep = DogRepositoryFactory.getInstance().getRepository();
    dogRep.insert(...);
    dogRep.update(...);
    Dog dog = dogRep.getById(10);

# Utilização do LoggerWrapper
De acordo com o que o professor falo na sala de aula, foi implementado o LogWrapper para que possamos ter o mais controle dos logs gerados na aplicação.

Exemplo de uso:
```java
        LoggerWrapper.log("Log");
```
A configuração da tag e se o debug está habilitado estão na propria classe do LoggerWrapper (com.tinderdog.util.LoggerWrapper).
    
