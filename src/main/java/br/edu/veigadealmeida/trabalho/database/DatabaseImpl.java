/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.veigadealmeida.trabalho.database;

import br.edu.veigadealmeida.trabalho.model.Model;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Pedro
 */
public abstract class DatabaseImpl<ID, Type extends Model> implements Database<ID, Type> {
    
    private final File file;
    private final Class<? extends Type> modelClass;
    
    public DatabaseImpl(String id, Class<? extends Type> modelClass) {
        file = new File(id + ".txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch(Exception exception) {
                exception.printStackTrace();
            }
        }
        this.modelClass = modelClass;
    }

    public File getFile() {
        return file;
    }
    
    public void write(String[] lines) {
        try {
            Files.newBufferedWriter(getFile().toPath(), StandardOpenOption.TRUNCATE_EXISTING);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                for(String line : lines)
                    writer.append(line).append(System.lineSeparator());
            }
        } catch(Exception exception) {
            exception.printStackTrace();
        }
    }
    
    public String[] read() {
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while(line != null) {
                builder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
            return builder.toString().split(System.lineSeparator());
        } catch(Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    
    @Override
    public List<Type> findAll() {
        return Arrays.stream(read()).map(s -> {
            if(s == null || s.isEmpty()) return null;
            return (Type) Model.fromLine(this.modelClass, s);
        }).filter(type -> type != null).toList();
    }
    
    @Override
    public Type find(ID id) {
        return findAll().stream().filter(type -> type.getName().equals(id)).findFirst().orElse(null);
    }

    @Override
    public void save(List<Type> types) {
        write(types.stream().filter(type -> type != null).map(Model::toLine).toList().toArray(new String[0]));
    }
}