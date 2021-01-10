package util.react;

public class ReactBlob {


    public String blobId(){
        return "<div id=\"like_button_container\"></div>";
    }

    public String blobId(int j){
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=j; i++)
            sb.append("<div id=\"like_button_container"+i+"\"></div>" );
        return sb.toString();
    }

    public String blobScript(int i){
        String basic = "<script type=\"text/babel\">\n" +
                "      ReactDOM.render(\n" +
                "        <h1>Hello, world!</h1>,\n" +
                "        document.getElementById('root')\n" +
                "      );\n";
        StringBuilder sb= new StringBuilder();
        sb.append(basic);
        sb.append(mounting(i));
        sb.append("</script>");
        return sb.toString();
    };

    public String mounting(int j){
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=j; i++)
            sb.append("      const domContainer"+i+" = document.querySelector('#like_button_container"+i+"');\n" +
                    "      ReactDOM.render(e(LikeButton), domContainer"+i+");\n" );
        return sb.toString();

    };
}
