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
