# Princípios SOLID

Explicação dos princípios SOLID para a matéria de Engenharia de Software.

### S - Single Responsability Principle (Princípio da Responsabilidade Única)
#

O princípio da Responsabilidade Única estabelece que uma classe deve ter uma única razão para mudar, ou seja, uma única tarefa ou responsabilidade. Esse conceito promove a modularidade, coesão e facilidade de teste do código, reduzindo sua propensão a bugs.

O [código](./BookMain.java) define duas classes: `Book` e `BookPrinter`.

- `Book`: A classe representa um livro. Ela tem três campos privados para armazenar o título, o autor e o texto do livro. Ela tem um construtor para inicializar esses campos e métodos getter para recuperar esses valores. A única responsabilidade desta classe é manter os dados do livro.
```
class Book {
    private String title;
    private String author;
    private String text;

    public Book(String title, String author, String text) {
        this.title = title;
        this.author = author;
        this.text = text;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getText() {
        return this.text;
    }
}
```

- `BookPrinter`: A classe é responsável por imprimir o livro. Ela tem dois métodos: `printTextToConsole` que imprime uma string no console, e `printBookToConsole` que aceita um objeto `Book` e imprime os detalhes do livro no console. A única responsabilidade desta classe é imprimir os dados do livro.
```
class BookPrinter {
    public void printTextToConsole(String text) {
        System.out.println(text);
    }

    public void printBookToConsole(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Text: " + book.getText());
    }
}
```

O princípio da Responsabilidade Única é usado para separar as responsabilidades de manter os dados do livro e imprimir os dados do livro em duas classes diferentes. Isso torna o código mais fácil de gerenciar e entender.

Além disso, se precisarmos alterar a maneira como os detalhes do livro são impressos, podemos fazer isso alterando apenas a classe `BookPrinter`, sem afetar a classe `Book`. Da mesma forma, se precisarmos alterar a maneira como os detalhes do livro são armazenados, podemos fazer isso alterando apenas a classe `Book`, sem afetar a classe `BookPrinter`. Isso é o problema que o princípio da Responsabilidade Única resolve. Ele ajuda a manter o código modular, facilita a manutenção e minimiza o risco de bugs.

## O - Open-Closed Principle (Princípio Aberto-Fechado)

O princípio Open-Closed afirma que as entidades de software (classes, módulos, funções, etc.) devem estar abertas para extensão, mas fechadas para modificação. Essa abordagem é valiosa, pois reduz o risco de introduzir novos bugs no código existente, torna o código mais robusto a mudanças e melhora a reutilização do código. Além disso, torna o sistema mais fácil de manter e expandir ao longo do tempo, pois novas funcionalidades podem ser adicionadas com alterações mínimas no código existente.

O [código](./VehicleMain.java) define uma classe abstrata `Vehicle` e duas classes concretas `Car` e `Motorcycle` que estendem `Vehicle`. Além disso, define uma classe `VehicleRepairShop` que pode reparar qualquer tipo de `Vehicle`.

- `Vehicle`: É uma classe abstrata com um método abstrato `repair`. Qualquer classe que estenda `Vehicle` deve implementar este método.

```
abstract class Vehicle {
    public abstract void repair();
}
```

- `Car` e `Motorcycle`: São subclasses de `Vehicle` que implementam o método `repair`. O método `repair` imprime uma mensagem indicando que o carro ou a motocicleta está sendo reparado.

```
class Car extends Vehicle {
    public void repair() {
        System.out.println("Repairing car...");
    }
}

class Motorcycle extends Vehicle {
    public void repair() {
        System.out.println("Repairing motorcycle...");
    }
}
```

- `VehicleRepairShop`: A classe tem um método `repairVehicle` que aceita um `Vehicle` como argumento e chama o método `repair` do `Vehicle`.

```
class VehicleRepairShop {
    public void repairVehicle(Vehicle vehicle) {
        vehicle.repair();
    }
}
```

- `VehicleMain`:  É a classe principal que cria um `VehicleRepairShop`, um `Car` e um `Motorcycle`, e pede ao `VehicleRepairShop` para reparar o `Car` e o `Motorcycle`. `Car` e `Motorcycle` são criados como `Vehicle`, demonstrando que eles podem ser tratados como instâncias de `Vehicle`. O `VehicleRepairShop` é capaz de reparar ambos, apesar de serem tipos diferentes, porque ambos são subclasses de `Vehicle`.

```
public class VehicleMain {
    public static void main(String[] args) {
        VehicleRepairShop shop = new VehicleRepairShop();

        Vehicle car = new Car();
        Vehicle motorcycle = new Motorcycle();

        shop.repairVehicle(car);
        shop.repairVehicle(motorcycle);
    }
}
```

O princípio Open-Closed é aplicado para permitir que o `VehicleRepairShop` possa reparar qualquer tipo de `Vehicle` sem a necessidade de modificação. Quando um novo tipo de `Vehicle` é criado, ele pode ser passado para o método `repairVehicle` do `VehicleRepairShop` sem a necessidade de alterações no próprio `VehicleRepairShop`. Isso é possível porque o `VehicleRepairShop` depende da abstração `Vehicle`, não das classes concretas `Car` e `Motorcycle`.

O problema que o princípio resolve é a necessidade de modificar o `VehicleRepairShop` sempre que um novo tipo de `Vehicle` é adicionado. Ao seguir esse princípio, o `VehicleRepairShop` pode ser estendido para reparar novos tipos de `Vehicle` sem precisar ser modificado, garantindo assim sua extensibilidade e flexibilidade ao lidar com diferentes tipos de veículos.

### L - Liskov Segregation Principle (Princípio da Substituição de Liskov)
#

O princípio da Substituição de Liskov afirma que, se uma classe B é uma subclasse de A, então devemos ser capazes de substituir A por B sem interromper o comportamento do programa. Esse princípio é fundamental para garantir o uso seguro da polimorfia, permitindo que objetos de uma superclasse sejam substituídos por objetos de uma subclasse sem impactar o funcionamento do programa. Além de facilitar a polimorfia, o princípio promove a reutilização do código e a modularidade, aspectos cruciais para o desenvolvimento de sistemas robustos e escaláveis.

O [código](./AnimalMain.java) define uma classe `Animal` e uma classe `Dog` que estende `Animal`. Ambas as classes têm um método `eat`.

- `Animal`: É uma classe com um método `eat` que imprime a mensagem "Animal eats".

```
class Animal {
    void eat() {
        System.out.println("The animal is eating");
    }
}
```

- `Dog`: É uma subclasse de `Animal` que sobrescreve o método `eat` para imprimir a mensagem "Dog eats".

```
class Dog extends Animal {
    @Override
    void eat() {
        System.out.println("The dog is eating");
    }
}
```

- `AnimalMain`: É a classe principal que cria um `Animal` e um `Dog`, mas ambos são referenciados como `Animal`. Quando o método `eat` é chamado em ambos, o comportamento correto é executado dependendo do tipo real do objeto (Animal ou Dog).

```
public class AnimalMain {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Animal dog = new Dog();

        animal.eat();  
        dog.eat();  
    }
}
```
            
O princípio da Substituição de Liskov é aplicado aqui para permitir que um objeto do tipo `Dog` seja utilizado em qualquer contexto onde um objeto do tipo `Animal` é esperado. Essa possibilidade é viabilizada pelo fato de que `Dog` é uma subclasse de `Animal`, possibilitando que um `Dog` seja referenciado como um `Animal`. Quando o método `eat` é invocado em um objeto `Animal`, o comportamento apropriado é executado, levando em consideração o tipo real do objeto.

O problema resolvido neste caso é assegurar o uso seguro da polimorfia. Graças a esse princípio, podemos invocar o método `eat` em qualquer objeto que seja um `Animal`, e o comportamento adequado será executado, mesmo se o objeto real for um `Dog`. Isso torna o código mais flexível e de fácil manutenção, pois permite a adição de novos tipos de `Animal` sem necessidade de modificar o código que opera em `Animal`.

### I — Interface Segregation Principle (Princípio da Segregação da Interface)
#

O Princípio da Segregação de Interface é usado para garantir que as classes não tenham que implementar métodos que não precisam. Em vez disso, interfaces grandes devem ser divididas em interfaces menores e mais específicas, para que as classes só precisem implementar os métodos que são relevantes para elas. Isso torna o código mais modular e fácil de entender, pois cada classe e interface tem uma responsabilidade clara e bem definida. Além disso, facilita a manutenção e a extensão do código, pois as mudanças em uma interface não afetam as classes que não dependem dessa interface.

O [código](./FlyableMain.java) define duas interfaces, `Flyable` e `Driveable`, e duas classes, `Airplane` e `Car`, que implementam essas interfaces. Além disso, define uma classe `FlyableMain` que cria um `Airplane` e um `Car` e chama seus respectivos métodos.

- `Flyable`: É uma interface com um único método `fly`. Qualquer classe que implemente `Flyable` deve fornecer uma implementação para este método.

```
interface Flyable {
    void fly();
}
```

- `Driveable`: É uma interface com um único método `drive`. Qualquer classe que implemente `Driveable` deve fornecer uma implementação para este método.

```
interface Driveable {
    void drive();
}
```

- `Airplane`: É uma classe que implementa a interface `Flyable`. Ela fornece uma implementação para o método `fly` que imprime a mensagem "Airplane is flying.".

```
class Airplane implements Flyable {
    public void fly() {
        System.out.println("Airplane is flying.");
    }
}
```

- `Car`: É uma classe que implementa a interface `Driveable`. Ela fornece uma implementação para o método `drive` que imprime a mensagem "Car is driving.".

```
class Car implements Driveable {
    public void drive() {
        System.out.println("Car is driving.");
    }
}
```

- `FlyableMain`: Um `Airplane` e um `Car` são criados e seus respectivos métodos são chamados. Isso demonstra que cada classe só precisa implementar e conhecer os métodos que são relevantes para ela.

```
public class FlyableMain {
    public static void main(String[] args) {
        Airplane airplane = new Airplane();
        airplane.fly();

        Car car = new Car();
        car.drive();
    }
}
```

O princípio da Segregação de Interface é usado para separar as responsabilidades de voar e dirigir em duas interfaces diferentes. Isso permite que `Airplane` implemente apenas os métodos que fazem sentido para um avião (ou seja, fly), e `Car` implemente apenas os métodos que fazem sentido para um carro (ou seja, drive). Isso evita que `Airplane` seja forçado a implementar um método `drive` desnecessário, e `Car` seja forçado a implementar um método `fly` desnecessário.

O problema que o princípio resolve é a necessidade de classes implementarem métodos que não precisam. Ao seguir o ISP, cada classe implementa apenas os métodos que são relevantes para ela, tornando o código mais claro, mais fácil de manter e menos propenso a erros.

### D — Dependency Inversion Principle (Princípio da inversão da dependência)
#

O Princípio da Inversão de Dependência afirma que módulos de alto nível não devem depender de módulos de baixo nível. Ambos devem depender de abstrações. Além disso, abstrações não devem depender de detalhes. Detalhes devem depender de abstrações. Esse princípio aumenta a flexibilidade do código, tornando-o mais fácil de modificar e estender. É possível alterar a implementação de uma classe sem impactar outras classes. Além disso, é possível adicionar novas funcionalidades com menos risco de quebrar funcionalidades já existentes.

O [código](./SwitchableMain.java) define uma interface `Switchable`, duas classes `LightBulb` e `Fan` que implementam essa interface, uma classe `PowerSwitch` que opera em um objeto `Switchable`, e uma classe `SwitchableMain` que usa essas classes.

- `Switchable`: É uma interface com dois métodos, `turnOn` e `turnOff`. Qualquer classe que implemente `Switchable` deve fornecer uma implementação para esses métodos.

```
interface Switchable {
    void turnOn();
    void turnOff();
}
```

- `LightBulb` e `Fan`: São classes que implementam a interface `Switchable`. Elas fornecem implementações para os métodos `turnOn` e `turnOff` que imprimem mensagens indicando que a lâmpada ou o ventilador foram ligados ou desligados.

```
class LightBulb implements Switchable {
    public void turnOn() {
        System.out.println("LightBulb turned on");
    }

    public void turnOff() {
        System.out.println("LightBulb turned off");
    }
}

class Fan implements Switchable {
    public void turnOn() {
        System.out.println("Fan turned on");
    }

    public void turnOff() {
        System.out.println("Fan turned off");
    }
}
```

- `PowerSwitch`: A classe tem um campo device do tipo `Switchable` e um método `press` que chama os métodos `turnOn` e `turnOff` do `device`. Isso significa que `PowerSwitch` pode operar em qualquer objeto que implemente a interface `Switchable`.

```
class PowerSwitch {
    private Switchable device;

    public PowerSwitch(Switchable device) {
        this.device = device;
    }

    public void press() {
        device.turnOn();
        device.turnOff();
    }
}
```

- `SwitchableMain`: É a classe principal que cria um `LightBulb` e um `Fan`, ambos como `Switchable`, e um `PowerSwitch` para cada. Em seguida, chama o método `press` em cada `PowerSwitch`.

```
public class SwitchableMain {
    public static void main(String[] args) {
        Switchable bulb = new LightBulb();
        PowerSwitch bulbSwitch = new PowerSwitch(bulb);
        bulbSwitch.press();

        Switchable fan = new Fan();
        PowerSwitch fanSwitch = new PowerSwitch(fan);
        fanSwitch.press();
    }
}
```

O princípio da Inversão de Dependência é usado para fazer `PowerSwitch` depender da abstração `Switchable`, não das implementações concretas `LightBulb` e `Fan`. Isso permite que `PowerSwitch` opere em qualquer objeto `Switchable`, tornando o código mais flexível e menos acoplado.

O problema que o princípio resolve é a necessidade de modificar `PowerSwitch` sempre que um novo tipo de dispositivo que pode ser ligado e desligado é adicionado. Graças ao DIP, um novo dispositivo pode ser adicionado simplesmente implementando a interface `Switchable`, sem a necessidade de modificar `PowerSwitch`.