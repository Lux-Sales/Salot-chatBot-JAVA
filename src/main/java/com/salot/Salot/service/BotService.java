package com.salot.Salot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ChatAction;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendChatAction;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BotService {

    TelegramBot bot;
    GetUpdatesResponse receptor;
    @Autowired
    Disparador disparador;
    int id = 0;

    public BotService() {

        this.bot = new TelegramBot("1008391680:AAFYN-8r5GXY79bOTMT0NkR6w_pda-bv6pU");
    }

    @Scheduled(fixedRate = 500)
    public void execute() {
        // while (true) {
        receptor = bot.execute(new GetUpdates().limit(100).offset(id));
        List<Update> ListaDeMensagens = receptor.updates();

        for (Update mensagens : ListaDeMensagens) {
            System.out.println(mensagens.message().text());
            if (mensagens.message().text().toUpperCase().equals("/START")) {
                disparador.dispararMensagemString("Bot iniciado\n" + "Olá  " + mensagens.message().chat().firstName() +
                        ", me chamo Salot, sou um bot de um jovem estudante da Universidade" +
                        " de brasília, campus do gama, não posso fazer muito por você ainda " +
                        "pois comecei a dar meus primeiros passos agora, mas eis o que posso fazer:\n" +
                        "-Contar uma piada\n\n" + "Caso queira ouvir uma piada, digite ''piada''", mensagens);

            }
            if (mensagens.message().text().toUpperCase().equals("PIADA")) {
                disparador.dispararMensagemString("Pensei em contar uma de química para voce " + "mas acho que não terá reação", mensagens);
            }

            id = mensagens.updateId() + 1;
            bot.execute(new SendChatAction(mensagens.message().chat().id(), ChatAction.typing.name()));
        }
    }
}