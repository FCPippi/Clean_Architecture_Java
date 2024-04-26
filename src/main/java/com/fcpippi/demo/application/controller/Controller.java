package com.fcpippi.demo.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fcpippi.demo.application.dto.AplicativoDTO;
import com.fcpippi.demo.application.dto.AssinaturaDTO;
import com.fcpippi.demo.application.dto.ClienteDTO;
import com.fcpippi.demo.application.dto.CriaAssinaturaDTO;
import com.fcpippi.demo.application.dto.RegistraPagamentoDTO;
import com.fcpippi.demo.application.useCases.AtualizaCustoMensalUC;
import com.fcpippi.demo.application.useCases.CriaAssinaturaUC;
import com.fcpippi.demo.application.useCases.ListaAplicativosUC;
import com.fcpippi.demo.application.useCases.ListaAssinaturaAplicativoUC;
import com.fcpippi.demo.application.useCases.ListaAssinaturaClienteUC;
import com.fcpippi.demo.application.useCases.ListaAssinaturaTipoUC;
import com.fcpippi.demo.application.useCases.ListaClientesUC;
import com.fcpippi.demo.application.useCases.RegistraPagamentoUC;
import com.fcpippi.demo.application.useCases.VerificaValidadeAssinaturaUC;

@RestController
public class Controller {
    private AtualizaCustoMensalUC atualizaCustoMensalUC;
    private CriaAssinaturaUC criaAssinaturaUC;
    private ListaAplicativosUC listaAplicativosUC;
    private ListaAssinaturaClienteUC listaAssinaturaClienteUC;
    private ListaAssinaturaAplicativoUC listaAssinaturasAplicativoUC;
    private ListaAssinaturaTipoUC listaAssinaturaTipoUC;
    private ListaClientesUC listaClientesUC;
    private RegistraPagamentoUC registraPagamentoUC;
    private VerificaValidadeAssinaturaUC verificaValidadeAssinaturaUC;

    @Autowired
    public Controller(AtualizaCustoMensalUC atualizaCustoMensalUC, CriaAssinaturaUC criaAssinaturaUC,
            ListaAplicativosUC listaAplicativosUC, ListaAssinaturaClienteUC listaAssinaturaClienteUC,
            ListaAssinaturaAplicativoUC listaAssinaturaAplicativoUC,
            ListaAssinaturaTipoUC listaAssinaturaTipoUC, ListaClientesUC listaClientesUC,
            RegistraPagamentoUC registraPagamentoUC,
            VerificaValidadeAssinaturaUC verificaValidadeAssinaturaUC) {
        this.atualizaCustoMensalUC = atualizaCustoMensalUC;
        this.criaAssinaturaUC = criaAssinaturaUC;
        this.listaAplicativosUC = listaAplicativosUC;
        this.listaAssinaturaClienteUC = listaAssinaturaClienteUC;
        this.listaAssinaturasAplicativoUC = listaAssinaturaAplicativoUC;
        this.listaAssinaturaTipoUC = listaAssinaturaTipoUC;
        this.listaClientesUC = listaClientesUC;
        this.registraPagamentoUC = registraPagamentoUC;
        this.verificaValidadeAssinaturaUC = verificaValidadeAssinaturaUC;
    }

    @GetMapping("/servcad/clientes")
    @CrossOrigin(origins = "*")
    public List<ClienteDTO> listaClientes() {
        return this.listaClientesUC.run();
    }

    @GetMapping("/servcad/aplicativos")
    @CrossOrigin(origins = "*")
    public List<AplicativoDTO> listaAplicativos() {
        return this.listaAplicativosUC.run();
    }

    @GetMapping("/servcad/assinaturas/{tipo}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> listaAssinaturasTipo(@PathVariable(value = "tipo") String tipo) {
        return this.listaAssinaturaTipoUC.run(tipo);
    }

    @GetMapping("/servcad/asscli/{codcli}")
    @CrossOrigin
    public List<AssinaturaDTO> listaAssinaturasCliente(@PathVariable(value = "codcli") Long codigoCliente) {
        return this.listaAssinaturaClienteUC.run(codigoCliente);
    }

    @GetMapping("/servcad/assapp/{codapp}")
    @CrossOrigin(origins = "*")
    public List<AssinaturaDTO> listaAssinaturasAplicativo(@PathVariable(value = "codapp") Long codigoAplicativo) {
        return this.listaAssinaturasAplicativoUC.run(codigoAplicativo);
    }

    @GetMapping("/assinvalida/{codass}")
    @CrossOrigin(origins = "*")
    public boolean verificaValidadeAssinatura(@PathVariable(value = "codass") Long codigoAssinatura) {
        return this.verificaValidadeAssinaturaUC.run(codigoAssinatura);
    }

    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody CriaAssinaturaDTO criaAssinaturaDTO) {
        return this.criaAssinaturaUC.run(criaAssinaturaDTO.getCodigoCliente(), criaAssinaturaDTO.getCodigoAplicativo());
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    @CrossOrigin(origins = "*")
    public AplicativoDTO atualizaCusto(@PathVariable(value = "idAplicativo") Long codigoAplicativo,
            @RequestBody Double custoMensal) {
        return this.atualizaCustoMensalUC.run(codigoAplicativo, custoMensal);
    }

    @PostMapping("/registrapagamento")
    @CrossOrigin(origins = "*")
    public Object registraPagamento(@RequestBody RegistraPagamentoDTO pagamentoDTO) {
        return this.registraPagamentoUC.run(pagamentoDTO.getDia(), pagamentoDTO.getMes(), pagamentoDTO.getAno(),
                pagamentoDTO.getCodigoAssinatura(), pagamentoDTO.getValorPago());
    }
}
