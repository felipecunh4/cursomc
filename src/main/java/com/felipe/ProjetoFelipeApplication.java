package com.felipe;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.felipe.domain.Categoria;
import com.felipe.domain.Cidade;
import com.felipe.domain.Cliente;
import com.felipe.domain.Endereco;
import com.felipe.domain.Estado;
import com.felipe.domain.Pagamento;
import com.felipe.domain.PagamentoComBoleto;
import com.felipe.domain.PagamentoComCartao;
import com.felipe.domain.Pedido;
import com.felipe.domain.Produto;
import com.felipe.domain.enums.EstadoPagamento;
import com.felipe.domain.enums.TipoCliente;
import com.felipe.repositories.CategoriaRepository;
import com.felipe.repositories.CidadeRepository;
import com.felipe.repositories.ClienteRepository;
import com.felipe.repositories.EnderecoRepository;
import com.felipe.repositories.EstadoRepository;
import com.felipe.repositories.PagamentoRepository;
import com.felipe.repositories.PedidoRepository;
import com.felipe.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoFelipeApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoFelipeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado e1 = new Estado(null, "Minas Gerais");
		Estado e2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", e1);
		Cidade c2 = new Cidade(null, "São Paulo", e2);
		Cidade c3 = new Cidade(null, "Campinas", e2);
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "12485992772", TipoCliente.PESSOAFISICA);
		
		Endereco end1 = new Endereco(null, "Rua Flores", "300", "Ap 300", "Jardim", "92038461", cli1, c1);
		Endereco end2 = new Endereco(null, "Rua Matos", "300", "Sala 300", "Centro", "22384019", cli1, c2);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Pedido ped1 = new Pedido(null, sdf.parse("22/05/2019 09:51"), cli1, end1);
		Pedido ped2 = new Pedido(null, sdf.parse("01/05/2019 03:42"), cli1, end1);
		
		Pagamento pag1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		Pagamento pag2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2018 10:10"), null);
		
		ped1.setPagamento(pag1);
		ped2.setPagamento(pag2);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		e1.getCidades().addAll(Arrays.asList(c1));
		e2.getCidades().addAll(Arrays.asList(c2,c3));
		
		cli1.getTelefones().addAll(Arrays.asList("930272182", "98429401"));
		cli1.getEnderecos().addAll(Arrays.asList(end1, end2));
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(e1,e2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(end1, end2));
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));
		
	}

}
