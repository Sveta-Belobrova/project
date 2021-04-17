using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace project1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlConnection conn = new SqlConnection();
            conn.ConnectionString = @"Data Source=LAPTOP-11302SKF\SQLEXPRESS;Initial Catalog=project;Integrated Security=True";
            conn.Open();
            SqlCommand myCommand = conn.CreateCommand();

            myCommand.CommandText = "select admit, password" + " from pols where  admit=@p2 and password=@p1";

           myCommand.Parameters.Add("@p2", SqlDbType.NVarChar, 150);
            myCommand.Parameters["@p2"].Value = this.textBox1.Text;
            myCommand.Parameters.Add("@p1", SqlDbType.NVarChar, 150);
           myCommand.Parameters["@p1"].Value = this.textBox2.Text;

            SqlDataReader reader = myCommand.ExecuteReader();

            if (reader.HasRows) // если есть данные
            {
                while (reader.Read()) // построчно считываем данные
                {
                    MessageBox.Show("Добро пожаловать, " + reader["admit"]);
                    Form3 newForm = new Form3();
                    newForm.Owner = this;
                    newForm.Show();
                }
            }
            reader.Close();
            conn.Close();
                                
        }

        private void linkLabel2_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {
            Form2 newForm = new Form2();
              newForm.Owner = this;
            newForm.Show();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void linkLabel1_LinkClicked(object sender, LinkLabelLinkClickedEventArgs e)
        {

        }
    }
}
