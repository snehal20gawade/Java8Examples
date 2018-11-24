package library;

import lombok.Data;

@Data
public class Author {

    private String name;

    private int id;


    @Override
        public boolean equals(Object obj){
            if(this == obj)
                return true;

            if(obj == null)
                return false;

            if(getClass() != obj.getClass())
                return false;
            Author author = (Author) obj;

            if(name == author.name){
                return true;
            }
         if(id == author.id) {
             return true;
         }
         return true;
    }
    @Override
    public int hashCode() {
        int result = 6 ;
        result = 31 * result + name.hashCode();
        result = 31 * result + id;
        return result;

    }

}