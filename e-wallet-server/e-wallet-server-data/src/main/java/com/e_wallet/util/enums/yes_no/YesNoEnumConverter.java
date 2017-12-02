package com.e_wallet.util.enums.yes_no;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by Redpike
 */
@Converter
public class YesNoEnumConverter implements AttributeConverter<YesNoEnum, String> {

    @Override
    public String convertToDatabaseColumn(YesNoEnum yesNoEnum) {
        return yesNoEnum.getDatabaseValue();
    }

    @Override
    public YesNoEnum convertToEntityAttribute(String dbData) {
        return YesNoEnum.valueOf(dbData);
    }
}
