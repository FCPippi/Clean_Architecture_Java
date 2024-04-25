package com.fcpippi.demo.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fcpippi.demo.application.dto.AplicativoDTO;
import com.fcpippi.demo.application.dto.AssinaturaDTO;
import com.fcpippi.demo.application.dto.ClienteDTO;
import com.fcpippi.demo.application.useCases.AtualizaCustoMensalUC;
import com.fcpippi.demo.application.useCases.CriaAssinaturaUC;
import com.fcpippi.demo.application.useCases.ListaAplicativosUC;
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
    private ListaAssinaturaTipoUC listaAssinaturaTipoUC;
    private ListaClientesUC listaClientesUC;
    private RegistraPagamentoUC registraPagamentoUC;
    private VerificaValidadeAssinaturaUC VerificaValidadeAssinaturaUC;

    public Controller(AtualizaCustoMensalUC atualizaCustoMensalUC, CriaAssinaturaUC criaAssinaturaUC,
            ListaAplicativosUC listaAplicativosUC, ListaAssinaturaClienteUC listaAssinaturaClienteUC,
            ListaAssinaturaTipoUC listaAssinaturaTipoUC, ListaClientesUC listaClientesUC,
            RegistraPagamentoUC registraPagamentoUC,
            com.fcpippi.demo.application.useCases.VerificaValidadeAssinaturaUC verificaValidadeAssinaturaUC) {
        this.atualizaCustoMensalUC = atualizaCustoMensalUC;
        this.criaAssinaturaUC = criaAssinaturaUC;
        this.listaAplicativosUC = listaAplicativosUC;
        this.listaAssinaturaClienteUC = listaAssinaturaClienteUC;
        this.listaAssinaturaTipoUC = listaAssinaturaTipoUC;
        this.listaClientesUC = listaClientesUC;
        this.registraPagamentoUC = registraPagamentoUC;
        VerificaValidadeAssinaturaUC = verificaValidadeAssinaturaUC;
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
    public List<AssinaturaDTO> listaAssinaturasTipo(String tipo) {
        return this.listaAssinaturasTipo(tipo);
    }

    @PostMapping("/servcad/assinaturas")
    @CrossOrigin(origins = "*")
    public AssinaturaDTO criaAssinatura(@RequestBody Long codigoCliente, @RequestBody Long codigoAplicativo) {
        return this.criaAssinaturaUC.run(codigoCliente, codigoAplicativo);
    }

    @PostMapping("/servcad/aplicativos/atualizacusto/{idAplicativo}")
    @CrossOrigin(origins = "*")
    public AplicativoDTO atualizaCusto(@PathVariable(value = "idAplicativo") Long codigoAplicativo,
            @RequestBody Double custoMensal) {
        return this.atualizaCustoMensalUC.run(codigoAplicativo, custoMensal);
    }
}
