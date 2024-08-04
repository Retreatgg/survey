package com.example.survey.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Institutes {

    INSTITUTE_OF_DESIGN_ARCHITECTURE_AND_TEXTILES("ИНСТИТУТ ДИЗАЙНА, АРХИТЕКТУРА И ТЕКСТИЛЯ"),
    INSTITUTE_OF_DIGITAL_TRANSFORMATION_AND_PROGRAMMING("ИНСТИТУТ ЦИФРОВОЙ ТРАНСФОРМАЦИИ И ПРОГРАММИРОВАНИЯ"),
    INSTITUTE_OF_CONSTRUCTION_AND_INNOVATIVE_TECHNOLOGIES("ИНСТИТУТ СТРОИТЕЛЬСТВА И ИННОВАЦИОННЫХ ТЕХНОЛОГИЙ"),
    INSTITUTE_OF_ENERGY_AND_TRANSPORT("ИНСТИТУТ ЭНЕРГЕТИКИ И ТРАНСПОРТА"),
    INSTITUTE_OF_ECONOMICS_AND_MANAGEMENT("ИНСТИТУТ ЭКОНОМИКИ И МЕНЕДЖМЕНТА"),
    INSTITUTE_OF_THE_RUSSIAN_KYRGYZ_INSTITUTE_OF_AUTOMATION_OF_BUSINESS_MANAGEMENT("ИНСТИТУТ РОССИЙСКО-КЫРГЫЗСКОГО ИНСТИТУТА АВТОМАТИЗАЦИИ УПРАВЛЕНИЯ БИЗНЕСА"),
    INSTITUTE_OF_INTERCULTURAL_COMMUNICATION_AND_PSYCHOLOGY("ИНСТИТУТ МЕЖКУЛЬТУРНОЙ КОММУНИКАЦИИ И ПСИХОЛОГИИ"),
    INSTITUTE_OF_MARKETING_AND_E_COMMERCE("ИНСТИТУТ МАРКЕТИНГА И ЭЛЕКТРОННОЙ КОММЕРЦИИ"),
    STRUCTURAL_UNITS("СТРУКТУРНЫЕ ПОДРАЗДЕЛЕНИЯ"),
    KITE("КИТЭ"),
    COMTEHNO("КОМТЕХНО");

    private final String name;

    @Override
    public String toString() {
        return name;
    }

}
