package AondeFruta;

public class Tree {
    private String name;                        // nome dado a árvore adicionada
    private String stateTree;                   // estado
    private String cityTree;                    // cidade
    private int geoPositionTree;                // posição no mapa
    private TreePosition treePosition;          // vindo do objeto TreePosition que contém cidade/estado/posição
    private String photoPath;                   // foto da árvore a ser adicionar

    public Tree(String name, String stateTree, String cityTree, int geoPositionTree, String photoPath){     //construtor
        this.treePosition = new TreePosition(stateTree, cityTree, geoPositionTree);
        setDetails(name, treePosition, photoPath);
    }

    public String getName(){                    // retorna o nome da árvore
        return name;
    }

    public String getStateTree(){               // retorna o estado da árvore
        if(stateTree != null){
            return stateTree;
        } else {
            return "State not found!";
        }
    }

    public String getCityTree(){              // retorna a cidade da árvore
        if(cityTree != null){
            return cityTree;
        } else {
            return "City not found!";
        }
    }

    public int getGeoPositionTree(){        // retorna a posição no mapa da árvore
        return geoPositionTree;
    }

    public String getPhotoPath(){          // retorna "imagem" da árvore
        return photoPath;
    }

    public String getDetails(){            // retorna detalhes da árvore
        return "Seu nome é:" + name + "/ UF: " + stateTree + " / Cidade: " + cityTree + " / Posição: " + geoPositionTree;
    }

    private void setDetails(String name, TreePosition treePosition, String photoPath){  // atribui o nome, foto,
        this.name = name;                                                               // position(cidade, estado, posição
        this.treePosition = treePosition;
        this.photoPath = photoPath;
    }
}
