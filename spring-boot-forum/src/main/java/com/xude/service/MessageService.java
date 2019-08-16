package com.xude.service;

import com.xude.persistence.model.TMessage;
import com.xude.persistence.model.User;
import com.xude.web.dto.UserRegistrationDto;
import com.xude.web.dto.UserSettingsDto;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface MessageService {

List<TMessage> getAll();
void saveMessge(TMessage tMessage);
void updateMessge(TMessage tMessage);

}
