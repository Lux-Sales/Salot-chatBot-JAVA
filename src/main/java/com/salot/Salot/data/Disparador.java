package com.salot.Salot.data;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class Disparador {
    public SendResponse disparador;
    public TelegramBot bot = new TelegramBot("1008391680:AAFYN-8r5GXY79bOTMT0NkR6w_pda-bv6pU");

    public void dispararMensagemString(String texto, Update mensagem) {
        disparador = bot.execute(new SendMessage(mensagem.message().chat().id(), texto));
    }
}
