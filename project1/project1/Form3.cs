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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void загрузитьToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form5 newForm = new Form5();
            newForm.Owner = this;
            newForm.Show();
        }

        private void жанрыToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form7 newForm = new Form7();
            newForm.Owner = this;
            newForm.Show();
        }

        private void авторыToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form6 newForm = new Form6();
            newForm.Owner = this;
            newForm.Show();
        }

        private void категорииToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form8 newForm = new Form8();
            newForm.Owner = this;
            newForm.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string t="";
            listBox1.Items.Clear();
           

            SqlConnection cann = new SqlConnection();
            cann.ConnectionString = @"Data Source=LAPTOP-11302SKF\SQLEXPRESS;Initial Catalog=project;Integrated Security=True";
            cann.Open();

            SqlCommand myCommand = cann.CreateCommand();
            if (comboBox1.Text == "наименование")
            {
                t = "select name from knigs";
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();

                if (reader.HasRows) // если есть данные
                {
                    while (reader.Read()) // построчно считываем данные
                    {
                        listBox1.Items.Add(reader["name"]);
                    }
                }
                reader.Close();
            }
            else if (comboBox1.Text == "автор")
            {
                t = "select name_av from avtor";
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();

                if (reader.HasRows) // если есть данные
                {
                    while (reader.Read()) // построчно считываем данные
                    {
                        listBox1.Items.Add(reader["name_av"]);
                    }
                }
                reader.Close();
            }
            else if (comboBox1.Text == "категория")
            {
                t = "select name_kater from kater";
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();

                if (reader.HasRows) // если есть данные
                {
                    while (reader.Read()) // построчно считываем данные
                    {
                        listBox1.Items.Add(reader["name_kater"]);
                    }
                }
                reader.Close();
            }
            else if (comboBox1.Text == "жанр")
            {
                t = "select name_sch from schanrs";
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();

                if (reader.HasRows) // если есть данные
                {
                    while (reader.Read()) // построчно считываем данные
                    {
                        listBox1.Items.Add(reader["name_sch"]);
                    }
                }
                reader.Close();
            }
            
            cann.Close();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            dataGridView1.Rows.Clear();
            string t;
            SqlConnection cann = new SqlConnection();
            cann.ConnectionString = @"Data Source=LAPTOP-11302SKF\SQLEXPRESS;Initial Catalog=project;Integrated Security=True";
            cann.Open();
            SqlCommand myCommand = cann.CreateCommand();
            if (comboBox1.Text == "наименование")
            {
                t = "select knigs.name, avtor.name_av, kater.name_kater, schanrs.name_sch from avtor inner join (kater inner join (schanrs inner join knigs on schanrs.kod_sch=knigs.kod_sc) on kater.kod_kater=knigs.kod_katerorja) on avtor.kod_av=knigs.kod_av where knigs.name=@p1";
                myCommand.Parameters.Add("@p1", SqlDbType.NVarChar, 50);
                myCommand.Parameters["@p1"].Value = this.listBox1.Text;
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();
                List<string[]> data = new List<string[]>();
               

                if (reader.HasRows) // если есть данные
                {
                   
                    while (reader.Read()) // построчно считываем данные
                    {
                        data.Add(new string[4]);

                        data[data.Count - 1][0] = reader[0].ToString();
                        data[data.Count - 1][1] = reader[1].ToString();
                        data[data.Count - 1][2] = reader[2].ToString();
                        data[data.Count - 1][3] = reader[3].ToString();
                        }
                }
                reader.Close();
                foreach (string[] s in data)
                    dataGridView1.Rows.Add(s);
            }
            else if (comboBox1.Text == "автор")
            {
                t = "select knigs.name, avtor.name_av, kater.name_kater, schanrs.name_sch from avtor inner join (kater inner join (schanrs inner join knigs on schanrs.kod_sch=knigs.kod_sc) on kater.kod_kater=knigs.kod_katerorja) on avtor.kod_av=knigs.kod_av where avtor.name_av=@p1";
                myCommand.Parameters.Add("@p1", SqlDbType.NVarChar, 50);
                myCommand.Parameters["@p1"].Value = this.listBox1.Text;
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();
                List<string[]> data = new List<string[]>();


                if (reader.HasRows) // если есть данные
                {

                    while (reader.Read()) // построчно считываем данные
                    {
                        data.Add(new string[4]);

                        data[data.Count - 1][0] = reader[0].ToString();
                        data[data.Count - 1][1] = reader[1].ToString();
                        data[data.Count - 1][2] = reader[2].ToString();
                        data[data.Count - 1][3] = reader[3].ToString();
                    }
                }
                reader.Close();
                foreach (string[] s in data)
                    dataGridView1.Rows.Add(s);
            }
            else if (comboBox1.Text == "категория")
            {
                t = "select knigs.name, avtor.name_av, kater.name_kater, schanrs.name_sch from avtor inner join (kater inner join (schanrs inner join knigs on schanrs.kod_sch=knigs.kod_sc) on kater.kod_kater=knigs.kod_katerorja) on avtor.kod_av=knigs.kod_av where kater.name_kater=@p1";
                myCommand.Parameters.Add("@p1", SqlDbType.NVarChar, 50);
                myCommand.Parameters["@p1"].Value = this.listBox1.Text;
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();
                List<string[]> data = new List<string[]>();


                if (reader.HasRows) // если есть данные
                {

                    while (reader.Read()) // построчно считываем данные
                    {
                        data.Add(new string[4]);

                        data[data.Count - 1][0] = reader[0].ToString();
                        data[data.Count - 1][1] = reader[1].ToString();
                        data[data.Count - 1][2] = reader[2].ToString();
                        data[data.Count - 1][3] = reader[3].ToString();
                    }
                }
                reader.Close();
                foreach (string[] s in data)
                    dataGridView1.Rows.Add(s);
            }
            else if (comboBox1.Text == "жанр")
            {
                t = "select knigs.name, avtor.name_av, kater.name_kater, schanrs.name_sch from avtor inner join (kater inner join (schanrs inner join knigs on schanrs.kod_sch=knigs.kod_sc) on kater.kod_kater=knigs.kod_katerorja) on avtor.kod_av=knigs.kod_av where schanrs.name_sch=@p1";
                myCommand.Parameters.Add("@p1", SqlDbType.NVarChar, 50);
                myCommand.Parameters["@p1"].Value = this.listBox1.Text;
                myCommand.CommandText = t;
                SqlDataReader reader = myCommand.ExecuteReader();
                List<string[]> data = new List<string[]>();


                if (reader.HasRows) // если есть данные
                {

                    while (reader.Read()) // построчно считываем данные
                    {
                        data.Add(new string[4]);

                        data[data.Count - 1][0] = reader[0].ToString();
                        data[data.Count - 1][1] = reader[1].ToString();
                        data[data.Count - 1][2] = reader[2].ToString();
                        data[data.Count - 1][3] = reader[3].ToString();
                    }
                }
                reader.Close();
                foreach (string[] s in data)
                    dataGridView1.Rows.Add(s);
            }

            cann.Close();
        }

        private void listBox1_Click(object sender, EventArgs e)
        {
            
        }

    }
}
