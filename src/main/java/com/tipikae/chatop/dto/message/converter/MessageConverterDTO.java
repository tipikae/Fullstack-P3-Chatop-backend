package com.tipikae.chatop.dto.message.converter;

import com.tipikae.chatop.dto.message.MessageDTO;
import com.tipikae.chatop.dto.message.NewMessageDTO;
import com.tipikae.chatop.exceptions.ConverterDTOException;
import com.tipikae.chatop.models.Message;
import com.tipikae.chatop.models.Rental;
import com.tipikae.chatop.models.User;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Message converter DTO.
 */
@Component
public class MessageConverterDTO implements IMessageConverterDTO {

    /**
     * Convert a NewMessageDTO to a Message.
     *
     * @param newMessageDTO NewMessageDTO object.
     * @param sender        User sender.
     * @param rental        Rental about.
     * @return Message
     * @throws ConverterDTOException thrown when a converter exception occurred.
     */
    @Override
    public Message convertNewMessageDTOTOModel(NewMessageDTO newMessageDTO, User sender, Rental rental) throws ConverterDTOException {
        Message message = new Message();

        try {
            message.setMessage(newMessageDTO.getMessage());
            message.setUser(sender);
            message.setRental(rental);
            message.setCreatedAt(LocalDateTime.now());
        } catch (Exception e) {
            throw new ConverterDTOException(e.getMessage());
        }

        return message;
    }

    /**
     * Convert a Message to a MessageDTO.
     *
     * @param message Message object.
     * @return MessageDTO
     * @throws ConverterDTOException thrown when a converter exception occurred.
     */
    @Override
    public MessageDTO convertMessageToDTO(Message message) throws ConverterDTOException {
        MessageDTO messageDTO = new MessageDTO();

        try {
            messageDTO.setId(message.getId());
            messageDTO.setMessage(messageDTO.getMessage());
            messageDTO.setUserId(message.getUser().getId());
            messageDTO.setRentalId(message.getRental().getId());
            messageDTO.setCreatedAt(message.getCreatedAt());
            message.setUpdatedAt(message.getUpdatedAt());
        } catch (Exception e) {
            throw new ConverterDTOException(e.getMessage());
        }

        return messageDTO;
    }
}
