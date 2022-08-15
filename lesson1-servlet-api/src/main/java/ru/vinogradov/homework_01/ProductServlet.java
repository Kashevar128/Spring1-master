package ru.vinogradov.homework_01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;    private PrintWriter writer;

    @Override
    public void init() throws ServletException {
        this.productRepository = new ProductRepository();
        this.productRepository.insert(new Product("Potato"));
        this.productRepository.insert(new Product("Carrot"));
        this.productRepository.insert(new Product("Beet"));
        this.productRepository.insert(new Product("Egg"));
        this.productRepository.insert(new Product("Chicken"));
        this.productRepository.insert(new Product("Onion"));
        this.productRepository.insert(new Product("Bread"));
        this.productRepository.insert(new Product("Milk"));
        this.productRepository.insert(new Product("Cheese"));
        this.productRepository.insert(new Product("Tomato"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        Long longPathInfo = null;
        this.writer = response.getWriter();

        try {

            if(pathInfo != null) {
                longPathInfo = Long.parseLong(pathInfo.substring(1));
                if(!productRepository.findId(longPathInfo)) {
                    throw new ThereIsNoSuchValueException();
                }
                printProductById(longPathInfo);
            }
            else printAllTable();

        } catch (NumberFormatException e) {
            response.sendError(400, "Неверный формат индекса");
        } catch (ThereIsNoSuchValueException e) {
            response.sendError(400, "Такого индекса не существует");
        }

    }

    private void printHeaderTable() throws IOException {
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>id</th>");
        writer.println("<th>productName</th>");
        writer.println("</tr>");
    }

    private void printLineTable(Product product) throws IOException {
            writer.println("<tr>");
            writer.println("<td><a href=" + getServletContext().getContextPath() + "/product/" + product.getId() + ">" + product.getId() + "</a></td>");
            writer.println("<td>" + product.getProductname() + "</td>");
            writer.println("</tr>");
    }

    private void printAllTable() throws IOException {
        printHeaderTable();
        productRepository.findAll().stream().forEach((product)-> {
            try {
                printLineTable(product);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void printProductById(Long id) throws IOException {
        Product product = productRepository.findById(id);
        printHeaderTable();
        printLineTable(product);
    }


}
