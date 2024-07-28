
import java.util.ArrayList;

public class Node {
    
    ArrayList<Integer>routes = new ArrayList<>();
    ArrayList<Node>children = new ArrayList<>();
    int numVertex;
    int depot;
    
    public Node(int numVertex, int depot) {
        this.numVertex = numVertex;
        this.depot = depot;
    }
    
    public void expand(){
        if(routes.size()<=0){
            routes.add(depot);
            expand();
        }else{
            for (int i = 1; i <= numVertex; i++) {
                boolean ada = false;
                for (int j = 0; j < routes.size(); j++) {
                    if(routes.get(j)==i){
                        ada = true;
                        break;
                    }
                }
                if(!ada){
                    Node node = new Node(numVertex, depot);
                    for (int j = 0; j < routes.size(); j++) {
                        node.routes.add(routes.get(j));
                    }
                    node.routes.add(i);
                    node.numVertex = numVertex;
                    node.depot = depot;
                    if(node.routes.size()==numVertex){
                        node.routes.add(depot);
                        System.out.println(node.routes);
                    }else{
                        node.expand();
                    }                    
                }
            }
            
        }
    }

}
