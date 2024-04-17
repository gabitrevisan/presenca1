//Gabriela Trevisan da Silva - RMM99500 (Turma 2ESPW)

// Classe Funcionario representa os atributos comuns a todos os funcionários
class Funcionario {
    // Atributos
    private String nome;
    private int idade;
    private double salario;

    // Construtor
    public Funcionario(String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    // Método calcularSalario será implementado nas subclasses
    public double calcularSalario() {
        return salario;
    }

    // Getters e setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}

// Subclasse FuncionarioIntegral
class FuncionarioIntegral extends Funcionario {
    // Construtor
    public FuncionarioIntegral(String nome, int idade, double salario) {
        super(nome, idade, salario);
    }

    // Implementação do método calcularSalario para FuncionarioIntegral
    @Override
    public double calcularSalario() {
        return getSalario(); // Salário fixo
    }
}

// Subclasse FuncionarioPorHora
class FuncionarioPorHora extends Funcionario {
    // Atributo adicional para armazenar as horas trabalhadas
    private int horasTrabalhadas;

    // Construtor
    public FuncionarioPorHora(String nome, int idade, double salario, int horasTrabalhadas) {
        super(nome, idade, salario);
        this.horasTrabalhadas = horasTrabalhadas;
    }

    // Implementação do método calcularSalario para FuncionarioPorHora
    @Override
    public double calcularSalario() {
        return getSalario() * horasTrabalhadas; // Salário multiplicado pelo número de horas trabalhadas
    }

    // Getter e setter para horasTrabalhadas
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
}

// Subclasse Gerente
class Gerente extends Funcionario {
    // Atributo adicional para armazenar o bônus de desempenho
    private double bonus;

    // Construtor
    public Gerente(String nome, int idade, double salario, double bonus) {
        super(nome, idade, salario);
        this.bonus = bonus;
    }

    // Implementação do método calcularSalario para Gerente
    @Override
    public double calcularSalario() {
        return getSalario() + bonus; // Salário base mais o bônus de desempenho
    }

    // Getter e setter para bonus
    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}

// Classe Main para demonstrar o uso do sistema
public class Main {
    public static void main(String[] args) {
        // Instanciando alguns funcionários
        FuncionarioIntegral funcionarioIntegral = new FuncionarioIntegral("João", 30, 3000.00);
        FuncionarioPorHora funcionarioPorHora = new FuncionarioPorHora("Maria", 25, 20.00, 40);
        Gerente gerente = new Gerente("Pedro", 35, 5000.00, 1000.00);

        // Imprimindo os salários dos funcionários
        System.out.println("Salário de " + funcionarioIntegral.getNome() + ": " + funcionarioIntegral.calcularSalario());
        System.out.println("Salário de " + funcionarioPorHora.getNome() + ": " + funcionarioPorHora.calcularSalario());
        System.out.println("Salário de " + gerente.getNome() + ": " + gerente.calcularSalario());
    }
}