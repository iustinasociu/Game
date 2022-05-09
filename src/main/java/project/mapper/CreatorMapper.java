package project.mapper;

import project.entity.Creator;
import project.rest.model.CreatorDTO;

public class CreatorMapper {

    public static Creator fromDTOToEntity(CreatorDTO creatorDTO){
        return new Creator(creatorDTO.getName(), creatorDTO.getNationality(), creatorDTO.getGames());
    }

    public static CreatorDTO fromEntityToDTO(Creator creator){
        return new CreatorDTO (creator.getId(), creator.getName(), creator.getNationality(),creator.getGames());
    }
}
